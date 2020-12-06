package cz.globex.hana.router.controller.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.*
import cz.globex.hana.router.controller.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [StockExchangesApiController.PATH])
internal class StockExchangesApiControllerImpl private constructor(
	private val requestUtils: RequestUtils,
	daoProvider: DaoProvider,
) : StockExchangesApiController {
	private val stockExchangesDao = daoProvider.stockExchangesDao

	@PostMapping
	override fun createStockExchange(
		@RequestBody stockExchange: StockExchangeCreateReplaceDto,
	): ResponseEntity<ResourceInfoDto<Long>> {
		val resourceInfo = stockExchangesDao.createAdvertisable(stockExchange, requestUtils.getActualUserId())
		return ResponseEntities.created(resourceInfo)
	}

	@GetMapping(path = [PathNodes.ID])
	override fun getStockExchange(@PathVariable(PathVariables.ID) id: Long): StockExchangeDto {
		return stockExchangesDao.getAdvertisable(id)
	}

	@GetMapping
	override fun getStockExchanges(
		filters: StockExchangeFiltersDto,
		pagination: PaginationDto,
	): StockExchangesDto {
		return stockExchangesDao.getAdvertisables(filters, pagination.toPageable())
	}

	@PutMapping(path = [PathNodes.ID])
	@ResponseStatus(HttpStatus.NO_CONTENT)
	override fun replaceStockExchange(
		@PathVariable(PathVariables.ID) id: Long,
		@RequestBody stockExchange: StockExchangeCreateReplaceDto,
	) {
		stockExchangesDao.replaceAdvertisable(id, stockExchange)
	}

	@DeleteMapping(path = [PathNodes.ID])
	@ResponseStatus(HttpStatus.NO_CONTENT)
	override fun deleteStockExchange(@PathVariable(PathVariables.ID) id: Long) {
		return stockExchangesDao.deleteAdvertisable(id)
	}

	@PostMapping(PathNodes.ID + PathNodes.RATINGS)
	override fun createRating(
		@PathVariable(PathVariables.ID) stockExchangeId: Long,
		@RequestBody rating: RatingCreateReplaceDto,
	): ResponseEntity<ResourceInfoDto<Long>> {
		val resourceInfo = stockExchangesDao.createRating(rating, requestUtils.getActualUserId(), stockExchangeId)
		return ResponseEntities.created(resourceInfo)
	}

	@GetMapping(PathNodes.ID + PathNodes.RATINGS + PathNodes.RATE_ID)
	override fun getRating(
		@PathVariable(PathVariables.ID) stockExchangeId: Long,
		@PathVariable(PathVariables.RATE_ID) ratingId: Long,
	): RatingDto {
		return stockExchangesDao.getRating(id = ratingId, advertisableId = stockExchangeId)
	}
}