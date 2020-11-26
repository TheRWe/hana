package cz.globex.hana.common.dto

import java.net.*
import java.time.*

interface EntityFiltersDto

interface EntitiesDto

interface EntityDto

interface EntityCreateDto

interface EntityUpdateDto

data class PaginationDto(
	val pageStart: Int? = null,
	val pageSize: Int? = null,
)

class ArticleFiltersDto : EntityFiltersDto

data class UserFiltersDto(
	val type: UserType?,
	val registeredStart: LocalDateTime?,
	val registeredEndInclusive: LocalDateTime?,
	val ratingAsSupplierScoreStart: Double?,
	val ratingAsSupplierScoreEndInclusive: Double?,
	val ratingAsSupplierVotesCountStart: Double?,
	val ratingAsSupplierVotesCountEndInclusive: Double?,
	val ratingAsSellerScoreStart: Double?,
	val ratingAsSellerScoreEndInclusive: Double?,
	val ratingAsSellerVotesCountStart: Double?,
	val ratingAsSellerVotesCountEndInclusive: Double?,
) : EntityFiltersDto

data class AdFiltersDto(
	val authorId: Long?,
	val placeLatitude: Double?,
	val placeLongitude: Double?,
	val placeRangeMeters: Int?,
	val createdStart: LocalDateTime?,
	val createdEndInclusive: LocalDateTime?,
	val tagName: Set<String>?,
	val isActual: Boolean?,
	val type: AdType?,
	val salaryStart: Int?,
	val salaryEndInclusive: Int?,
) : EntityFiltersDto

data class EventFiltersDto(
	val authorId: Long?,
	val placeLatitude: Double?,
	val placeLongitude: Double?,
	val placeRangeMeters: Int?,
	val createdStart: LocalDateTime?,
	val createdEndInclusive: LocalDateTime?,
	val tagName: Set<String>?,
	val ratingScoreStart: Double?,
	val ratingScoreEndInclusive: Double?,
	val ratingVotesCountStart: Double?,
	val ratingVotesCountEndInclusive: Double?,
	val dateStart: LocalDateTime?,
	val dateEndInclusive: LocalDateTime?,
	val entryFeeStart: Int?,
	val entryFeeEndInclusive: Int?,
) : EntityFiltersDto

data class StockExchangeFiltersDto(
	val authorId: Long?,
	val placeLatitude: Double?,
	val placeLongitude: Double?,
	val placeRangeMeters: Int?,
	val createdStart: LocalDateTime?,
	val createdEndInclusive: LocalDateTime?,
	val tagName: Set<String>?,
	val isActual: Boolean?,
	val type: StockExchangeType?,
	val costStart: Int?,
	val costEndInclusive: Int?,
) : EntityFiltersDto

data class ArticlesDto(
	val articles: List<ArticleDto>
) : EntitiesDto

data class ArticleDto(
	val title: String,
	val text: String,
) : EntityDto

data class ArticleCreateUpdateDto(
	val title: String,
	val text: String,
) : EntityCreateDto, EntityUpdateDto

data class UsersDto(
	val users: Set<UsersDto>,
) : EntitiesDto

data class UserDto(
	val id: Long,
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
	val id: Long,
	val authorId: Long,
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
	val authorId: Long,
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
	val id: Long,
	val authorId: Long,
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
	val authorId: Long,
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
	val id: Long,
	val authorId: Long,
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
	val authorId: Long,
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
	val id: Long,
	val url: URI,
)

data class RateDto(
	val score: Double,
)

data class ReportDto(
	val msg: String?
)