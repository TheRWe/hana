package cz.globex.hana.router.controller.impl

import cz.globex.hana.core.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.*
import cz.globex.hana.router.dto.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [StockExchangesApiController.PATH])
class StockExchangesApiControllerImpl(daoProvider: DaoProvider) : StockExchangesApiController {
	private val stockExchangesDao = daoProvider.stockExchangesDao

	override fun retrieveEntities(
		reqParams: StockExchangesRequestDto
	): ResponseEntity<StockExchangesDto> {
		TODO("Not yet implemented")
	}

	override fun createEntity(
		entity: StockExchangeCreateUpdateDto
	): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	override fun retrieveEntity(id: Int): ResponseEntity<StockExchangeDto> {
		TODO("Not yet implemented")
	}

	override fun updateEntity(
		id: Int,
		entity: StockExchangeCreateUpdateDto
	): ResponseEntity<Unit> {
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