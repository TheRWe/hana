package cz.globex.hana.controller.impl

import cz.globex.hana.controller.*
import cz.globex.hana.controller.dto.*
import cz.globex.hana.controller.util.*
import cz.globex.hana.core.dto.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [EventsApiController.PATH])
class EventsApiControllerImpl : EventsApiController {
	@GetMapping
	override fun retrieveEvents(reqParams: EventsRequestDto): ResponseEntity<EventsDto> {
		TODO("Not yet implemented")
	}

	@PostMapping
	override fun createEvent(
		@RequestBody event: EventCreateUpdateDto
	): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	@GetMapping(path = ["/{${PathVariables.ID}}"])
	override fun retrieveEvent(@PathVariable(PathVariables.ID) id: Int): ResponseEntity<EventDto> {
		TODO("Not yet implemented")
	}

	@PutMapping(path = ["/{${PathVariables.ID}}"])
	override fun updateEvent(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody event: EventCreateUpdateDto
	): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	@DeleteMapping(path = ["/{${PathVariables.ID}}"])
	override fun deleteEvent(@PathVariable(PathVariables.ID) id: Int): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	@PostMapping(path = ["/{${PathVariables.ID}}/rate"])
	override fun rateEvent(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody rate: RateDto
	): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	@PostMapping(path = ["/{${PathVariables.ID}}/report"])
	override fun reportEvent(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody report: ReportDto
	): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}
}