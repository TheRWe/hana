package cz.globex.hana.controller.dto

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
	val ratingAsCompanyTotalScoreStart: Double?,
	val ratingAsCompanyTotalScoreEndInclusive: Double?,
	val ratingAsCompanyVotesCountStart: Double?,
	val ratingAsCompanyVotesCountEndInclusive: Double?,
	val ratingAsSellerTotalScoreStart: Double?,
	val ratingAsSellerTotalScoreEndInclusive: Double?,
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
	val ratingTotalScoreStart: Double?,
	val ratingTotalScoreEndInclusive: Double?,
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
	val type: StockType?,
	val costStart: Int?,
	val costEndInclusive: Int?,
)

data class TagRequestDto(
	val id: Int,
)