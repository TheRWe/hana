package cz.globex.hana.router.controller

import cz.globex.hana.common.dto.*
import org.springframework.http.*

internal interface AdsApiController {
	companion object {
		const val PATH: String = ApiController.PATH + "/ads"
	}

	fun createAd(ad: AdCreateReplaceDto): ResponseEntity<ResourceInfoDto<Long>>

	fun getAd(id: Long): AdDto

	fun getAds(filters: AdFiltersDto, pagination: PaginationDto): AdsDto

	fun replaceAd(id: Long, ad: AdCreateReplaceDto)

	fun deleteAd(id: Long)

	fun createRating(
		adId: Long,
		rating: RatingCreateReplaceDto,
	): ResponseEntity<ResourceInfoDto<Long>>

	fun getRating(adId: Long, ratingId: Long): RatingDto
}