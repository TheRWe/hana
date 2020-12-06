package cz.globex.hana.core.dao.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.impl.*
import org.springframework.data.domain.*
import org.springframework.http.*
import org.springframework.stereotype.*
import org.springframework.transaction.annotation.*
import org.springframework.web.server.*
import java.time.*
import java.time.format.*
import java.util.stream.*
import javax.persistence.*
import kotlin.streams.*

@Component
internal class EventsDaoImpl protected constructor(
	private val eventsRepository: EventsRepository,
	private val usersRepository: UsersRepository,
	private val tagsRepository: TagsRepository,
	private val eventRatingsRepository: EventRatingsRepository,
) : EventsDao {
	@Transactional(readOnly = true)
	override fun getAdvertisables(filters: EventFiltersDto, pageable: Pageable): EventsDto {
//		val events: Set<EventDto> = eventsRepository
//			.findAllByIsDeletedFalse(pageable)
//			.get()
//			.map(Event::toDto)
//			.collect(Collectors.toSet())
//		return EventsDto(events)

		val createdStartUtc = filters.createdStartUtc?.let { LocalDateTime.parse(it, DateTimeFormatter.ISO_LOCAL_DATE_TIME) }
		val createdEndInclusiveUtc = filters.createdEndInclusiveUtc?.let { LocalDateTime.parse(it, DateTimeFormatter.ISO_LOCAL_DATE_TIME) }
		val dateStart = filters.dateStart?.let { LocalDateTime.parse(it, DateTimeFormatter.ISO_LOCAL_DATE_TIME) }
		val dateEndInclusive = filters.dateEndInclusive?.let { LocalDateTime.parse(it, DateTimeFormatter.ISO_LOCAL_DATE_TIME) }
		if (createdStartUtc != null && createdEndInclusiveUtc != null && createdStartUtc.isAfter(createdEndInclusiveUtc)) {
			throw ResponseStatusException(HttpStatus.BAD_REQUEST)
		}
		if (dateStart != null && dateEndInclusive != null && dateStart.isAfter(dateEndInclusive)) {
			throw ResponseStatusException(HttpStatus.BAD_REQUEST)
		}


		var eventsStream: Stream<Event> = eventsRepository.stream().filter { !it.isDeleted }

		// TODO: these operations should be done on the db level
		with(filters) {
			if (authorId != null) eventsStream = eventsStream.filter { authorId == it.author_safe.id }
			if (entryFeeStart != null) eventsStream = eventsStream.filter { entryFeeStart!! <= it.price }
			if (entryFeeEndInclusive != null) eventsStream = eventsStream.filter { entryFeeEndInclusive!! >= it.price }
			if (tagName != null) eventsStream = eventsStream.filter { tagName!!.map { tag -> tag.toLowerCase() }.union(it.tags.map { tag -> tag.name.toLowerCase() }).size == tagName!!.size }
			if (createdStartUtc != null) eventsStream = eventsStream.filter { it.createdUtc_safe.isAfter(createdStartUtc) || it.createdUtc_safe.isEqual(createdStartUtc) }
			if (createdEndInclusiveUtc != null) eventsStream = eventsStream.filter { it.createdUtc_safe.isBefore(createdEndInclusiveUtc) || it.createdUtc_safe.isEqual(createdEndInclusiveUtc) }
			if (ratingScoreStart != null) eventsStream = eventsStream.filter { if (it.ratingScore == null) false else ratingScoreStart!! <= it.ratingScore!! }
			if (ratingScoreEndInclusive != null) eventsStream = eventsStream.filter { if (it.ratingScore == null) false else ratingScoreEndInclusive!! >= it.ratingScore!! }
			if (ratingVotesCountStart != null) eventsStream = eventsStream.filter { ratingVotesCountStart!! <= it.ratingVotes }
			if (ratingVotesCountEndInclusive != null) eventsStream = eventsStream.filter { ratingVotesCountEndInclusive!! >= it.ratingVotes }
			if (dateStart != null) eventsStream = eventsStream.filter { dateStart!! <= it.dateEndInclusiveUtc }
			if (dateEndInclusive != null) eventsStream = eventsStream.filter { dateEndInclusive!! >= it.dateStartUtc }
		}
		val events: List<Event> = with(pageable) {
			if (isPaged) {
				eventsStream
					.limit((pageNumber * pageSize).toLong())
					.toList()
					.drop((pageNumber - 1) * pageSize)
			} else {
				eventsStream.toList()
			}
		}
		return EventsDto(events.mapTo(mutableSetOf(), Event::toDto))
	}

	@Transactional
	override fun createAdvertisable(advertisableDto: EventCreateReplaceDto, authorId: Long): Long {
		val dateStart = LocalDateTime.parse(advertisableDto.date.start, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
		val dateEndInclusive = LocalDateTime.parse(advertisableDto.date.endInclusive, DateTimeFormatter.ISO_LOCAL_DATE_TIME)

		val event = with(advertisableDto) {
			Event(
//				author = usersRepository.getByIdAndIsDeletedFalse(authorId),
				author = usersRepository.getOne(authorId),
				name = name,
				description = description,
				dateStartUtc = dateStart,
				dateEndInclusiveUtc = dateEndInclusive,
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
		val dateStart = LocalDateTime.parse(advertisableDto.date.start, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
		val dateEndInclusive = LocalDateTime.parse(advertisableDto.date.endInclusive, DateTimeFormatter.ISO_LOCAL_DATE_TIME)

		val event = eventsRepository.getByIdAndIsDeletedFalse(id)
		event.apply {
			name = advertisableDto.name
			description = advertisableDto.description
			dateStartUtc = dateStart
			dateEndInclusiveUtc = dateEndInclusive
			price = advertisableDto.entryFee
			photoUri = advertisableDto.photoUri
			place = null // TODO
			tags = tagsRepository.saveAll(advertisableDto.tags.map { Tag(it) }).toSet()
		}
		eventsRepository.save(event)
	}

	@Transactional
	override fun deleteAdvertisable(id: Long) {
		if (!eventsRepository.existsByIdAndIsDeletedFalse(id)) throw EntityNotFoundException()
		eventsRepository.deleteById(id)
	}

	override fun createRating(
		ratingDto: RatingCreateReplaceDto,
		authorId: Long,
		advertisableId: Long,
	): Long {
		val rating =
			EventRating(
//				usersRepository.getByIdAndIsDeletedFalse(authorId),
				usersRepository.getOne(authorId),
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