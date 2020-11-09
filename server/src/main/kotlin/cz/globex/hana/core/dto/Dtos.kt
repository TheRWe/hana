package cz.globex.hana.core.dto

import com.fasterxml.jackson.databind.annotation.*
import cz.globex.hana.router.deserializer.*
import java.net.*
import java.time.*

interface EntitiesDto

interface EntityDto

interface EntityCreateDto

interface EntityUpdateDto

data class ArticlesDto(
	val articles: List<ArticleDto>
) : EntitiesDto

data class ArticleDto(
	val title: String,
	val text: String,
) : EntityDto

data class ArticleCreateUpdateDto(
	@JsonDeserialize(using = StringDeserializer::class)
	val title: String,

	@JsonDeserialize(using = StringDeserializer::class)
	val text: String,
) : EntityCreateDto, EntityUpdateDto

data class UsersDto(
	val users: Set<UsersDto>,
) : EntitiesDto

data class UserDto(
	val id: Int,
	val firstName: String,
	val lastName: String,
	val email: String,
	val type: UserType,
	val registered: LocalDateTime,
	val photo: PhotoDto?,
	val ratings: UserRatingsDto?
) : EntityDto

data class UserCreateUpdateDto(
	val firstName: String,
	val lastName: String,
	val email: String,
	val type: UserType,
	val photo: PhotoDto?,
) : EntityCreateDto, EntityUpdateDto

enum class UserType { PERSON, COMPANY, CERTIFIED_COMPANY, MODERATOR, ADMINISTRATOR, }

data class UserRatingsDto(
	val asSupplier: RatingDto?,
	val asSeller: RatingDto?,
)

data class AdsDto(
	val ads: Set<AdDto>,
) : EntitiesDto

data class AdDto(
	val id: Int,
	val authorId: Int,
	val name: String,
	val description: String,
	val place: PlaceDto?,
	val photo: PhotoDto?,
	val tags: LinkedHashSet<TagDto>,
	val created: LocalDateTime,
	val isActual: Boolean,
	val payout: Int,
	val type: AdType,
) : EntityDto

data class AdCreateUpdateDto(
	val authorId: Int,
	val name: String,
	val description: String,
	val place: PlaceCreateUpdateDto?,
	val photo: PhotoDto?,
	val tags: TagCreateUpdateDto?,
	val isActual: Boolean,
	val payout: Int,
	val type: AdType,
) : EntityCreateDto, EntityUpdateDto

enum class AdType { SUPPLY, DEMAND, }

data class EventsDto(
	val events: Set<EventDto>,
) : EntitiesDto

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
) : EntityDto

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
) : EntityCreateDto, EntityUpdateDto

data class RatingDto(
	val score: Double,
	val votesCount: Int,
)

data class RangeDto<T>(
	val start: T,
	val endInclusive: T,
)

data class StockExchangesDto(
	val stockExchanges: Set<StockExchangeDto>,
) : EntitiesDto

data class StockExchangeDto(
	val id: Int,
	val authorId: Int,
	val name: String,
	val description: String,
	val place: PlaceDto?,
	val photo: PhotoDto?,
	val tags: LinkedHashSet<TagDto>,
	val created: LocalDateTime,
	val isActual: Boolean,
	val type: StockExchangeType,
	val cost: Int,
) : EntityDto

data class StockExchangeCreateUpdateDto(
	val authorId: Int,
	val name: String,
	val description: String,
	val place: PlaceCreateUpdateDto?,
	val photo: PhotoDto?,
	val tags: TagCreateUpdateDto?,
	val isActual: Boolean,
	val type: StockExchangeType,
	val cost: Int,
) : EntityCreateDto, EntityUpdateDto

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

enum class StockExchangeType { BUY, SELL, }

data class ResourceInfoDto(
	val id: Int,
	val url: URI,
)

data class RateDto(
	val score: Double,
)

data class ReportDto(
	val msg: String?
)