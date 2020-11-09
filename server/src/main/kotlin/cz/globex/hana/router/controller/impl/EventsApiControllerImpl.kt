package cz.globex.hana.router.controller.impl

import cz.globex.hana.core.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [EventsApiController.PATH])
class EventsApiControllerImpl(daoProvider: DaoProvider) : EventsApiController {
	private val eventsDao = daoProvider.eventsDao

	override fun retrieveMultiple(filters: EventFiltersDto): ResponseEntity<EventsDto> {
		TODO("Not yet implemented")
	}

	override fun create(entity: EventCreateUpdateDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	override fun retrieve(id: Int): ResponseEntity<EventDto> {
		TODO("Not yet implemented")
	}

	override fun update(id: Int, entity: EventCreateUpdateDto): ResponseEntity<Unit> {
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