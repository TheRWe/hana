package cz.globex.hana.router.controller.impl

import cz.globex.hana.core.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.*
import cz.globex.hana.router.dto.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [EventsApiController.PATH])
class EventsApiControllerImpl(daoProvider: DaoProvider) : EventsApiController {
	private val eventsDao = daoProvider.eventsDao

	override fun retrieveEntities(reqParams: EventsRequestDto): ResponseEntity<EventsDto> {
		TODO("Not yet implemented")
	}

	override fun createEntity(entity: EventCreateUpdateDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	override fun retrieveEntity(id: Int): ResponseEntity<EventDto> {
		TODO("Not yet implemented")
	}

	override fun updateEntity(id: Int, entity: EventCreateUpdateDto): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun deleteEntity(id: Int): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun rateEntity(id: Int, rate: RateDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	override fun reportEntity(id: Int, report: ReportDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}
}