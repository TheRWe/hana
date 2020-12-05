package cz.globex.hana.router.controller

import cz.globex.hana.common.dto.*
import org.springframework.http.*

internal interface EventsApiController {
	companion object {
		const val PATH: String = ApiController.PATH + "/events"
	}

	fun createEvent(event: EventCreateReplaceDto): ResponseEntity<ResourceInfoDto<Long>>

	fun getEvent(id: Long): EventDto

	fun getEvents(filters: EventFiltersDto, pagination: PaginationDto): EventsDto

	fun replaceEvent(id: Long, event: EventCreateReplaceDto)

	fun deleteEvent(id: Long)

	fun createRating(
		eventId: Long,
		rating: RatingCreateReplaceDto,
	): ResponseEntity<ResourceInfoDto<Long>>

	fun getRating(eventId: Long, ratingId: Long): RatingDto
}