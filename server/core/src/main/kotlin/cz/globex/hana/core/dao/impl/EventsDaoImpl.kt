package cz.globex.hana.core.dao.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.*
import cz.globex.hana.database.repository.impl.*
import org.springframework.data.domain.*
import org.springframework.stereotype.*
import org.springframework.transaction.annotation.*
import java.util.stream.*

@Component
internal class EventsDaoImpl protected constructor(
	private val eventsRepository: EventsRepository,
	private val usersRepository: UsersRepository,
	private val tagsRepository: TagsRepository,
	private val eventRatingsRepository: EventRatingsRepository,
) : EventsDao {
	@Transactional(readOnly = true)
	override fun getAdvertisables(filters: EventFiltersDto, pageable: Pageable): EventsDto {
		val events: Set<EventDto> = eventsRepository
			.findAllByIsDeletedFalse(pageable)
			.get()
			.map(Event::toDto)
			.collect(Collectors.toSet())
		return EventsDto(events)
	}

	@Transactional
	override fun createAdvertisable(advertisableDto: EventCreateReplaceDto, authorId: Long): Long {
		val event = with(advertisableDto) {
			Event(
				author = usersRepository.getByIdAndIsDeletedFalse(authorId),
				name = name,
				description = description,
				dateStartUtc = date.start,
				dateEndInclusiveUtc = date.endInclusive,
				price = entryFee,
				photoUri = photoUri,
				place = null, // TODO
				tags = tagsRepository.saveAll(advertisableDto.tags.map { Tag(it) }).toSet()
			)
		}
		return eventsRepository.save(event).id_safe
	}

	@Transactional(readOnly = true)
	override fun getAdvertisable(id: Long): EventDto = eventsRepository.getOne(id).toDto()

	override fun replaceAdvertisable(id: Long, advertisableDto: EventCreateReplaceDto) {
		val event = eventsRepository.getByIdAndIsDeletedFalse(id)
		event.apply {
			name = advertisableDto.name
			description = advertisableDto.description
			dateStartUtc = advertisableDto.date.start
			dateEndInclusiveUtc = advertisableDto.date.endInclusive
			price = advertisableDto.entryFee
			photoUri = advertisableDto.photoUri
			place = null // TODO
			tags = tagsRepository.saveAll(advertisableDto.tags.map { Tag(it) }).toSet()
		}
		eventsRepository.save(event)
	}

	override fun deleteAdvertisable(id: Long) {
		val event = eventsRepository.getByIdAndIsDeletedFalse(id)
		event.isDeleted = true
		eventsRepository.save(event)
	}

	override fun createRating(
		ratingDto: RatingCreateReplaceDto,
		authorId: Long,
		advertisableId: Long,
	): Long {
		val rating =
			EventRating(
				usersRepository.getByIdAndIsDeletedFalse(authorId),
				eventsRepository.getByIdAndIsDeletedFalse(advertisableId),
				ratingDto.score
			)
		return eventRatingsRepository.save(rating).id_safe
	}

	override fun getRating(id: Long, advertisableId: Long): RatingDto {
		return eventRatingsRepository
			.getByIdAndAdvertisableId(id = id, advertisableId = advertisableId)
			.toDto()
	}
}