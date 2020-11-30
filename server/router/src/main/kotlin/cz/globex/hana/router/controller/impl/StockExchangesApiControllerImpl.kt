package cz.globex.hana.router.controller.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.*
import cz.globex.hana.router.controller.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [StockExchangesApiController.PATH])
internal class StockExchangesApiControllerImpl private constructor(
	daoProvider: DaoProvider,
) : StockExchangesApiController {
	private val stockExchangesDao = daoProvider.stockExchangesDao

	override fun retrieveMultiple(
		filters: StockExchangeFiltersDto,
		pagination: PaginationDto,
	): ResponseEntity<StockExchangesDto> {
		return stockExchangesDao.retrieveMultipleAndWrap(filters, pagination)
	}

	override fun createOne(
		entity: StockExchangeCreateUpdateDto
	): ResponseEntity<ResourceInfoDto<Long>> {
		return stockExchangesDao.createOneAndWrap(entity)
	}

	override fun retrieveOne(id: Long): ResponseEntity<StockExchangeDto> {
		return stockExchangesDao.retrieveOneAndWrap(id)
	}

	override fun updateOne(id: Long, entity: StockExchangeCreateUpdateDto): ResponseEntity<Unit> {
		return stockExchangesDao.updateOneAndWrap(id, entity)
	}

	override fun deleteOne(id: Long): ResponseEntity<Unit> = stockExchangesDao.deleteOneAndWrap(id)

	override fun rateOne(id: Long, rate: RateDto): ResponseEntity<ResourceInfoDto<Long>> {
		return stockExchangesDao.rateOneAndWrap(id, rate)
	}

	override fun reportOne(id: Long, report: ReportDto): ResponseEntity<ResourceInfoDto<Long>> {
		return stockExchangesDao.reportOneAndWrap(id, report)
	}
}