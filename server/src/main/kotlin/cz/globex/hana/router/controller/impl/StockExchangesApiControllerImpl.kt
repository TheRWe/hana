package cz.globex.hana.router.controller.impl

import cz.globex.hana.router.controller.*
import cz.globex.hana.router.dto.*
import cz.globex.hana.router.util.*
import cz.globex.hana.core.*
import cz.globex.hana.core.dto.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [StockExchangesApiController.PATH])
class StockExchangesApiControllerImpl(daoProvider: DaoProvider) : StockExchangesApiController {
	private val stockExchangesDao = daoProvider.stockExchangesDao

	@GetMapping
	override fun retrieveStockExchanges(
		reqParams: StockExchangesRequestDto
	): ResponseEntity<StockExchangesDto> {
		TODO("Not yet implemented")
	}

	@PostMapping
	override fun createStockExchange(
		@RequestBody stockExchange: StockExchangeCreateUpdateDto
	): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	@GetMapping(path = ["/{${PathVariables.ID}}"])
	override fun retrieveStockExchange(
		@PathVariable(PathVariables.ID) id: Int
	): ResponseEntity<StockExchangeDto> {
		TODO("Not yet implemented")
	}

	@PutMapping(path = ["/{${PathVariables.ID}}"])
	override fun updateStockExchange(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody stockExchange: StockExchangeCreateUpdateDto
	): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	@DeleteMapping(path = ["/{${PathVariables.ID}}"])
	override fun deleteStockExchange(
		@PathVariable(PathVariables.ID) id: Int
	): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	@PostMapping(path = ["/{${PathVariables.ID}}/rate"])
	override fun rateStockExchange(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody rate: RateDto
	): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	@PostMapping(path = ["/{${PathVariables.ID}}/report"])
	override fun reportStockExchange(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody report: ReportDto
	): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}
}