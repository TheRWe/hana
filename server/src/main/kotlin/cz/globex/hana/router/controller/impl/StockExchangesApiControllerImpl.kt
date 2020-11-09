package cz.globex.hana.router.controller.impl

import cz.globex.hana.core.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.*
import cz.globex.hana.router.dto.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [StockExchangesApiController.PATH])
class StockExchangesApiControllerImpl(daoProvider: DaoProvider) : StockExchangesApiController {
	private val stockExchangesDao = daoProvider.stockExchangesDao

	@GetMapping
	override fun retrieveEntities(
		reqParams: StockExchangesRequestDto
	): ResponseEntity<StockExchangesDto> {
		TODO("Not yet implemented")
	}

	@PostMapping
	override fun createEntity(
		@RequestBody entity: StockExchangeCreateUpdateDto
	): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	@GetMapping(path = ["/{${PathVariables.ID}}"])
	override fun retrieveEntity(
		@PathVariable(PathVariables.ID) id: Int
	): ResponseEntity<StockExchangeDto> {
		TODO("Not yet implemented")
	}

	@PutMapping(path = ["/{${PathVariables.ID}}"])
	override fun updateEntity(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody entity: StockExchangeCreateUpdateDto
	): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	@DeleteMapping(path = ["/{${PathVariables.ID}}"])
	override fun deleteEntity(id: Int): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	@PostMapping(path = ["/{${PathVariables.ID}}/rate"])
	override fun rateEntity(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody rate: RateDto
	): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	@PostMapping(path = ["/{${PathVariables.ID}}/report"])
	override fun reportEntity(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody report: ReportDto
	): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}
}