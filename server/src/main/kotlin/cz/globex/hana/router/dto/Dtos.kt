package cz.globex.hana.router.dto

import cz.globex.hana.core.dto.*
import java.time.*

data class ArticlesRequestDto(
	val pageStart: Int?,
	val pageSize: Int?,
)

data class UsersRequestDto(
	val pageStart: Int?,
	val pageSize: Int?,
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
)

data class AdsRequestDto(
	val authorId: Int?,
	val place: PlaceDto?,
	val placeRangeMeters: Int?,
	val createdStart: LocalDateTime?,
	val createdEndInclusive: LocalDateTime?,
	val tags: Set<TagRequestDto>?,
	val pageStart: Int?,
	val pageSize: Int?,
	val isActual: Boolean?,
	val type: AdType?,
	val salaryStart: Int?,
	val salaryEndInclusive: Int?,
)

data class EventsRequestDto(
	val authorId: Int?,
	val place: PlaceDto?,
	val placeRangeMeters: Int?,
	val createdStart: LocalDateTime?,
	val createdEndInclusive: LocalDateTime?,
	val tags: Set<TagRequestDto>?,
	val pageStart: Int?,
	val pageSize: Int?,
	val ratingScoreStart: Double?,
	val ratingScoreEndInclusive: Double?,
	val ratingVotesCountStart: Double?,
	val ratingVotesCountEndInclusive: Double?,
	val dateStart: LocalDateTime?,
	val dateEndInclusive: LocalDateTime?,
	val entryFeeStart: Int?,
	val entryFeeEndInclusive: Int?,
)

data class StockExchangesRequestDto(
	val authorId: Int?,
	val place: PlaceDto?,
	val placeRangeMeters: Int?,
	val createdStart: LocalDateTime?,
	val createdEndInclusive: LocalDateTime?,
	val tags: Set<TagRequestDto>?,
	val pageStart: Int?,
	val pageSize: Int?,
	val isActual: Boolean?,
	val type: StockExchangeType?,
	val costStart: Int?,
	val costEndInclusive: Int?,
)

data class TagRequestDto(
	val id: Int,
)