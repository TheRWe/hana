package cz.globex.hana.controller

import cz.globex.hana.controller.dto.*
import cz.globex.hana.core.dto.*
import org.springframework.http.*

interface AdsApiController {
	companion object {
		const val PATH: String = ApiController.PATH + "/ads"
	}

	fun retrieveAds(reqParams: AdsRequestDto): ResponseEntity<AdsDto>

	fun createAd(ad: AdCreateUpdateDto): ResponseEntity<ResourceInfoDto>

	fun retrieveAd(id: Int): ResponseEntity<AdDto>

	fun updateAd(id: Int, ad: AdCreateUpdateDto): ResponseEntity<Unit>

	fun deleteAd(id: Int): ResponseEntity<Unit>

	fun rateAd(id: Int, rate: RateDto): ResponseEntity<ResourceInfoDto>

	fun reportAd(id: Int, report: ReportDto): ResponseEntity<ResourceInfoDto>
}