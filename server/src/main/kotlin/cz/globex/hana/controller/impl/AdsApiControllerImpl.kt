package cz.globex.hana.controller.impl

import cz.globex.hana.controller.*
import cz.globex.hana.controller.dto.*
import cz.globex.hana.controller.util.*
import cz.globex.hana.core.dto.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [AdsApiController.PATH])
class AdsApiControllerImpl : AdsApiController {
	@GetMapping
	override fun retrieveAds(reqParams: AdsRequestDto): ResponseEntity<AdsDto> {
		TODO("Not yet implemented")
	}

	@PostMapping
	override fun createAd(@RequestBody ad: AdCreateUpdateDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	@GetMapping(path = ["/{${PathVariables.ID}}"])
	override fun retrieveAd(@PathVariable(PathVariables.ID) id: Int): ResponseEntity<AdDto> {
		TODO("Not yet implemented")
	}

	@PutMapping(path = ["/{${PathVariables.ID}}"])
	override fun updateAd(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody ad: AdCreateUpdateDto
	): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	@DeleteMapping(path = ["/{${PathVariables.ID}}"])
	override fun deleteAd(@PathVariable(PathVariables.ID) id: Int): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	@PostMapping(path = ["/{${PathVariables.ID}}/rate"])
	override fun rateAd(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody rate: RateDto
	): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	@PostMapping(path = ["/{${PathVariables.ID}}/report"])
	override fun reportAd(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody report: ReportDto
	): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}
}