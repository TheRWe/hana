package cz.globex.hana.controller

import cz.globex.hana.controller.dto.*
import cz.globex.hana.core.dto.*
import org.springframework.http.*

interface EventsApiController {
	companion object {
		const val PATH: String = ApiController.PATH + "/events"
	}

	fun retrieveEvents(reqParams: EventsRequestDto): ResponseEntity<EventsDto>

	fun createEvent(event: EventCreateUpdateDto): ResponseEntity<ResourceInfoDto>

	fun retrieveEvent(id: Int): ResponseEntity<EventDto>

	fun updateEvent(id: Int, event: EventCreateUpdateDto): ResponseEntity<Unit>

	fun deleteEvent(id: Int): ResponseEntity<Unit>

	fun rateEvent(id: Int, rate: RateDto): ResponseEntity<ResourceInfoDto>

	fun reportEvent(id: Int, report: ReportDto): ResponseEntity<ResourceInfoDto>
}