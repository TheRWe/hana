package cz.globex.hana.core.dto

import com.fasterxml.jackson.databind.annotation.*
import cz.globex.hana.controller.deserializer.*
import java.net.*
import java.time.*

data class ArticlesDto(
	val articles: List<ArticleDto>
)

data class ArticleDto(
	@JsonDeserialize(using = StringDeserializer::class)
	val title: String,

	@JsonDeserialize(using = StringDeserializer::class)
	val text: String,
)

data class UsersDto(
	val users: Set<UsersDto>,
)

data class UserDto(
	val id: Int,
	val firstName: String,
	val lastName: String,
	val email: String,
	val type: UserType,
	val registered: LocalDateTime,
	val photo: PhotoDto?,
	val ratings: UserRatingsDto?
)

data class UserCreateUpdateDto(
	val firstName: String,
	val lastName: String,
	val email: String,
	val type: UserType,
	val photo: PhotoDto?,
)

enum class UserType { PERSON, COMPANY, CERTIFIED_COMPANY, MODERATOR, ADMINISTRATOR, }

data class UserRatingsDto(
	val asCompany: RatingDto?,
	val asSeller: RatingDto?,
)

data class AdsDto(
	val ads: Set<AdDto>,
)

data class AdDto(
	val id: Int,
	val authorId: Int,
	val name: String,
	val description: String,
	val place: PlaceDto?,
	val photo: PhotoDto?,
	val tags: LinkedHashSet<TagDto>,
	val created: LocalDateTime,
	val payout: Int,
	val type: AdType,
)

data class AdCreateUpdateDto(
	val authorId: Int,
	val name: String,
	val description: String,
	val place: PlaceCreateUpdateDto?,
	val photo: PhotoDto?,
	val tags: TagCreateUpdateDto?,
	val payout: Int,
	val type: AdType,
)

enum class AdType { SUPPLY, DEMAND, }

data class EventsDto(
	val events: Set<EventDto>,
)

data class EventDto(
	val id: Int,
	val authorId: Int,
	val name: String,
	val description: String,
	val place: PlaceDto?,
	val photo: PhotoDto?,
	val tags: LinkedHashSet<TagDto>,
	val created: LocalDateTime,
	val rating: RatingDto,
	val date: RangeDto<LocalDateTime>,
	val entryFee: Int
)

data class EventCreateUpdateDto(
	val authorId: Int,
	val name: String,
	val description: String,
	val place: PlaceCreateUpdateDto?,
	val photo: PhotoDto?,
	val tags: TagCreateUpdateDto?,
	val rating: RatingDto,
	val date: RangeDto<LocalDateTime>,
	val entryFee: Int,
)

data class RatingDto(
	val totalScore: Double,
	val votesCount: Int,
)

data class RangeDto<T>(
	val start: T,
	val endInclusive: T,
)

data class StockExchangesDto(
	val stockExchanges: Set<StockExchangeDto>,
)

data class StockExchangeDto(
	val id: Int,
	val authorId: Int,
	val name: String,
	val description: String,
	val place: PlaceDto?,
	val photo: PhotoDto?,
	val tags: LinkedHashSet<TagDto>,
	val created: LocalDateTime,
	val type: StockType,
	val cost: Int,
)

data class StockExchangeCreateUpdateDto(
	val authorId: Int,
	val name: String,
	val description: String,
	val place: PlaceCreateUpdateDto?,
	val photo: PhotoDto?,
	val tags: TagCreateUpdateDto?,
	val type: StockType,
	val cost: Int,
)

data class PlaceCreateUpdateDto(
	val latitude: Double,
	val longitude: Double,
)

data class TagCreateUpdateDto(
	val name: String,
)

data class PlaceDto(
	val name: String,
	val latitude: Double,
	val longitude: Double,
)

data class PhotoDto(
	val uri: URI
)

data class TagDto(
	val id: String,
	val name: String,
)

enum class StockType { BUY, SELL, EXCHANGE, }

data class ResourceInfoDto(
	val id: Int,
	val uri: URI,
)