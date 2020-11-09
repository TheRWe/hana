package cz.globex.hana.router.controller.impl

import cz.globex.hana.core.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [AdsApiController.PATH])
class AdsApiControllerImpl(daoProvider: DaoProvider) : AdsApiController {
	private val adsDao = daoProvider.adsDao

	override fun retrieveMultiple(filters: AdFiltersDto): ResponseEntity<AdsDto> {
		TODO("Not yet implemented")
	}

	override fun create(entity: AdCreateUpdateDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	override fun retrieve(id: Int): ResponseEntity<AdDto> {
		TODO("Not yet implemented")
	}

	override fun update(id: Int, entity: AdCreateUpdateDto): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun delete(id: Int): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun rate(id: Int, rate: RateDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	override fun report(id: Int, report: ReportDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}
}