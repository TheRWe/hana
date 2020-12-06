package cz.globex.hana.common.dto

import java.time.*

interface EntityFiltersDto

interface EntitiesDto

interface EntityDto

interface EntityCreateReplaceDto

data class PaginationDto(
	val pageStart: Int? = null,
	val pageSize: Int? = null,
)

class ArticleFiltersDto : EntityFiltersDto

data class UserFiltersDto(
	val type: UserType?,
	val registeredStartUtc: String?,
	val registeredEndInclusiveUtc: String?,
	val ratingAsSupplierScoreStart: Float?,
	val ratingAsSupplierScoreEndInclusive: Float?,
	val ratingAsSupplierVotesCountStart: Int?,
	val ratingAsSupplierVotesCountEndInclusive: Int?,
	val ratingAsSellerScoreStart: Float?,
	val ratingAsSellerScoreEndInclusive: Float?,
	val ratingAsSellerVotesCountStart: Int?,
	val ratingAsSellerVotesCountEndInclusive: Int?,
) : EntityFiltersDto

data class AdFiltersDto(
	val authorId: Long?,
	val placeLatitude: Double?,
	val placeLongitude: Double?,
	val placeRangeMeters: Int?,
	val createdStartUtc: String?,
	val createdEndInclusiveUtc: String?,
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
	val createdStartUtc: String?,
	val createdEndInclusiveUtc: String?,
	val tagName: Set<String>?,
	val ratingScoreStart: Float?,
	val ratingScoreEndInclusive: Float?,
	val ratingVotesCountStart: Int?,
	val ratingVotesCountEndInclusive: Int?,
	val dateStart: String?,
	val dateEndInclusive: String?,
	val entryFeeStart: Int?,
	val entryFeeEndInclusive: Int?,
) : EntityFiltersDto

data class StockExchangeFiltersDto(
	val authorId: Long?,
	val placeLatitude: Double?,
	val placeLongitude: Double?,
	val placeRangeMeters: Int?,
	val createdStartUtc: String?,
	val createdEndInclusiveUtc: String?,
	val tagName: Set<String>?,
	val isActual: Boolean?,
	val type: StockExchangeType?,
	val costStart: Int?,
	val costEndInclusive: Int?,
) : EntityFiltersDto

data class ArticlesDto(
	val articles: List<ArticleDto>,
) : EntitiesDto

data class ArticleDto(
	val title: String,
	val text: String,
) : EntityDto

data class ArticleCreateReplaceDto(
	val title: String,
	val text: String,
) : EntityCreateReplaceDto

data class UsersDto(
	val users: Set<UserDto>,
) : EntitiesDto

data class UserDto(
	val id: Long,
	val firstName: String,
	val lastName: String,
	val email: String,
	val type: UserType,
	val registeredUtc: LocalDateTime,
	val photoUri: String?,
	val ratings: UserRatingSummariesDto?,
) : EntityDto

data class UserCreateReplaceDto(
	val firstName: String,
	val lastName: String,
	val email: String,
	val type: UserType,
	val photoUri: String?,
) : EntityCreateReplaceDto

enum class UserType { ADMINISTRATOR, MODERATOR, CERTIFIED_COMPANY, COMPANY, PERSON, }

data class UserRatingSummariesDto(
	val asSupplier: RatingSummaryDto?,
	val asSeller: RatingSummaryDto?,
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
	val photoUri: String?,
	val tags: Set<String>,
	val createdUtc: LocalDateTime,
	val isActual: Boolean,
	val payout: Int,
	val type: AdType,
) : EntityDto

data class AdCreateReplaceDto(
	val name: String,
	val description: String,
	val place: PlaceCreateReplaceDto?,
	val photoUri: String?,
	val tags: Set<String>,
	val isActual: Boolean,
	val payout: Int,
	val type: AdType,
) : EntityCreateReplaceDto

enum class AdType { DEMAND, SUPPLY, }

data class EventsDto(
	val events: Set<EventDto>,
) : EntitiesDto

data class EventDto(
	val id: Long,
	val authorId: Long,
	val name: String,
	val description: String,
	val place: PlaceDto?,
	val photoUri: String?,
	val tags: Set<String>,
	val createdUtc: LocalDateTime,
	val rating: RatingSummaryDto?,
	val date: RangeDto<LocalDateTime>,
	val entryFee: Int,
) : EntityDto

data class EventCreateReplaceDto(
	val name: String,
	val description: String,
	val place: PlaceCreateReplaceDto?,
	val photoUri: String?,
	val tags: Set<String>,
	val date: RangeDto<String>,
	val entryFee: Int,
) : EntityCreateReplaceDto

enum class RatingScore(val value: Short) {
	UNSATISFACTORY(1), POOR(2), AVERAGE(3), GOOD(4), EXCELLENT(5),
}

data class RatingSummaryDto(
	val score: Float,
	val votesCount: Int,
) : EntityDto

data class RatingDto(
	val id: Long,
	val authorId: Long,
	val score: RatingScore,
) : EntityDto

open class RatingCreateReplaceDto(
	val score: RatingScore,
) : EntityCreateReplaceDto

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
	val photoUri: String?,
	val tags: Set<String>,
	val createdUtc: LocalDateTime,
	val isActual: Boolean,
	val type: StockExchangeType,
	val cost: Int,
) : EntityDto

data class StockExchangeCreateReplaceDto(
	val name: String,
	val description: String,
	val place: PlaceCreateReplaceDto?,
	val photoUri: String?,
	val tags: Set<String>,
	val isActual: Boolean,
	val type: StockExchangeType,
	val cost: Int,
) : EntityCreateReplaceDto

data class PlaceCreateReplaceDto(
	val latitude: Double,
	val longitude: Double,
)

data class PlaceDto(
	val name: String,
	val latitude: Double,
	val longitude: Double,
)

enum class StockExchangeType { BUY, SELL, }

data class ResourceInfoDto<ID : Comparable<ID>>(
	val id: ID,
	val url: String,
)

data class RateDto(
	val score: Double,
)

data class ReportDto(
	val msg: String?,
)