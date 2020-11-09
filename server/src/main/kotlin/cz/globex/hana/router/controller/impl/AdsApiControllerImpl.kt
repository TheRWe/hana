package cz.globex.hana.router.controller.impl

import cz.globex.hana.core.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.*
import cz.globex.hana.router.dto.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [AdsApiController.PATH])
class AdsApiControllerImpl(daoProvider: DaoProvider) : AdsApiController {
	private val adsDao = daoProvider.adsDao

	override fun retrieveEntities(reqParams: AdsRequestDto): ResponseEntity<AdsDto> {
		TODO("Not yet implemented")
	}

	override fun createEntity(entity: AdCreateUpdateDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	override fun retrieveEntity(id: Int): ResponseEntity<AdDto> {
		TODO("Not yet implemented")
	}

	override fun updateEntity(id: Int, entity: AdCreateUpdateDto): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun deleteEntity(id: Int): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun rateEntity(id: Int, rate: RateDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	override fun reportEntity(id: Int, report: ReportDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}
}