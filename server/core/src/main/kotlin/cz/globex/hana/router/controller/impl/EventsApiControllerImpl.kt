package cz.globex.hana.router.controller.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.*
import cz.globex.hana.router.controller.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [EventsApiController.PATH])
class EventsApiControllerImpl(daoProvider: DaoProvider) : EventsApiController {
	private val eventsDao = daoProvider.eventsDao

	override fun retrieveMultiple(
		filters: EventFiltersDto,
		pagination: PaginationDto
	): ResponseEntity<EventsDto> {
		return eventsDao.retrieveMultipleAndWrap(filters, pagination)
	}

	override fun createOne(entity: EventCreateUpdateDto): ResponseEntity<ResourceInfoDto> {
		return eventsDao.createOneAndWrap(entity)
	}

	override fun retrieveOne(id: Long): ResponseEntity<EventDto> = eventsDao.retrieveOneAndWrap(id)

	override fun updateOne(id: Long, entity: EventCreateUpdateDto): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun deleteOne(id: Long): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun rateOne(id: Long, rate: RateDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	override fun reportOne(id: Long, report: ReportDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}
}