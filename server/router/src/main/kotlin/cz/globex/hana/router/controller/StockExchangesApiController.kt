package cz.globex.hana.router.controller

import cz.globex.hana.common.dto.*
import org.springframework.http.*

internal interface StockExchangesApiController {
	companion object {
		const val PATH: String = ApiController.PATH + "/stock-exchanges"
	}

	fun createStockExchange(
		stockExchange: StockExchangeCreateReplaceDto,
	): ResponseEntity<ResourceInfoDto<Long>>

	fun getStockExchange(id: Long): StockExchangeDto

	fun getStockExchanges(
		filters: StockExchangeFiltersDto,
		pagination: PaginationDto,
	): StockExchangesDto

	fun replaceStockExchange(id: Long, stockExchange: StockExchangeCreateReplaceDto)

	fun deleteStockExchange(id: Long)

	fun createRating(
		stockExchangeId: Long,
		rating: RatingCreateReplaceDto,
	): ResponseEntity<ResourceInfoDto<Long>>

	fun getRating(stockExchangeId: Long, ratingId: Long): RatingDto
}