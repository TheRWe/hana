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
		filters: StockExchangeFiltersDto,
		pagination: PaginationDto
	): ResponseEntity<StockExchangesDto> {
		return stockExchangesDao.retrieveMultipleAndWrap(filters, pagination)
	}

	override fun createOne(entity: StockExchangeCreateUpdateDto): ResponseEntity<ResourceInfoDto> {
		return stockExchangesDao.createOneAndWrap(entity)
	}

	override fun retrieveOne(id: Int): ResponseEntity<StockExchangeDto> {
		return stockExchangesDao.retrieveOneAndWrap(id)
	}

	override fun updateOne(id: Int, entity: StockExchangeCreateUpdateDto): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun deleteOne(id: Int): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun rateOne(id: Int, rate: RateDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	override fun reportOne(id: Int, report: ReportDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}
}