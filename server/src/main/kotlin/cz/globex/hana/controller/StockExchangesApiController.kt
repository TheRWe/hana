package cz.globex.hana.controller

import cz.globex.hana.controller.dto.*
import cz.globex.hana.core.dto.*
import org.springframework.http.*

interface StockExchangesApiController {
	companion object {
		const val PATH: String = ApiController.PATH + "/stock-exchanges"
	}

	fun retrieveStockExchanges(reqParams: StockExchangesRequestDto): ResponseEntity<StockExchangesDto>

	fun createStockExchange(stockExchange: StockExchangeCreateUpdateDto): ResponseEntity<ResourceInfoDto>

	fun retrieveStockExchange(id: Int): ResponseEntity<StockExchangeDto>

	fun updateStockExchange(
		id: Int,
		stockExchange: StockExchangeCreateUpdateDto
	): ResponseEntity<Unit>

	fun deleteStockExchange(id: Int): ResponseEntity<Unit>

	fun rateStockExchange(id: Int, rate: RateDto): ResponseEntity<ResourceInfoDto>

	fun reportStockExchange(id: Int, report: ReportDto): ResponseEntity<ResourceInfoDto>
}