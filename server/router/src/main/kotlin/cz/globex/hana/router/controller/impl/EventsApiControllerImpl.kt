package cz.globex.hana.router.controller.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.*
import cz.globex.hana.router.controller.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [EventsApiController.PATH])
internal class EventsApiControllerImpl private constructor(
	daoProvider: DaoProvider,
) : EventsApiController {
	private val eventsDao = daoProvider.eventsDao

	@PostMapping
	override fun createEvent(
		@RequestBody event: EventCreateReplaceDto,
	): ResponseEntity<ResourceInfoDto<Long>> {
		return ResponseEntities.created(eventsDao.createAdvertisable(event, (1..100).random().toLong())) // TODO read current user from servletContext
	}

	@GetMapping(path = [PathNodes.ID])
	override fun getEvent(@PathVariable(PathVariables.ID) id: Long) = eventsDao.getAdvertisable(id)

	@GetMapping
	override fun getEvents(filters: EventFiltersDto, pagination: PaginationDto): EventsDto {
		return eventsDao.getAdvertisables(filters, pagination.toPageable())
	}

	@PutMapping(path = [PathNodes.ID])
	@ResponseStatus(HttpStatus.NO_CONTENT)
	override fun replaceEvent(
		@PathVariable(PathVariables.ID) id: Long,
		@RequestBody event: EventCreateReplaceDto,
	) {
		eventsDao.replaceAdvertisable(id, event)
	}

	@DeleteMapping(path = [PathNodes.ID])
	@ResponseStatus(HttpStatus.NO_CONTENT)
	override fun deleteEvent(@PathVariable(PathVariables.ID) id: Long) {
		eventsDao.deleteAdvertisable(id)
	}

	@PostMapping(PathNodes.ID + PathNodes.RATINGS)
	override fun createRating(
		@PathVariable(PathVariables.ID) eventId: Long,
		@RequestBody rating: RatingCreateReplaceDto,
	): ResponseEntity<ResourceInfoDto<Long>> {
		return ResponseEntities.created(eventsDao.createRating(rating, (1..100).random().toLong(), eventId)) // TODO read current user from servletContext
	}

	@GetMapping(PathNodes.ID + PathNodes.RATINGS + PathNodes.RATE_ID)
	override fun getRating(
		@PathVariable(PathVariables.ID) eventId: Long,
		@PathVariable(PathVariables.RATE_ID) ratingId: Long,
	): RatingDto {
		return eventsDao.getRating(id = ratingId, advertisableId = eventId)
	}
}