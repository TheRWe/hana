package cz.globex.hana.router.controller.impl

import cz.globex.hana.core.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [StockExchangesApiController.PATH])
class StockExchangesApiControllerImpl(daoProvider: DaoProvider) : StockExchangesApiController {
	private val stockExchangesDao = daoProvider.stockExchangesDao

	override fun retrieveMultiple(
		filters: StockExchangeFiltersDto
	): ResponseEntity<StockExchangesDto> {
		TODO("Not yet implemented")
	}

	override fun create(entity: StockExchangeCreateUpdateDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	override fun retrieve(id: Int): ResponseEntity<StockExchangeDto> {
		TODO("Not yet implemented")
	}

	override fun update(id: Int, entity: StockExchangeCreateUpdateDto): ResponseEntity<Unit> {
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