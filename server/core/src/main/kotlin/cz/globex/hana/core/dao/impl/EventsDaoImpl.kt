package cz.globex.hana.core.dao.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.*
import org.springframework.context.annotation.*
import org.springframework.data.domain.*
import org.springframework.transaction.annotation.*
import java.util.stream.*

@Configuration
internal class EventsDaoImpl protected constructor(
	private val eventsRepository: EventsRepository,
	private val usersRepository: UsersRepository,
	private val tagsRepository: TagsRepository,
) : EventsDao {
	@Transactional(readOnly = true)
	override fun retrieveMultiple(filters: EventFiltersDto, pageable: Pageable): EventsDto {
		val events: Set<EventDto> = eventsRepository
			.findAll(pageable)
			.get()
			.map(Event::toDto)
			.collect(Collectors.toSet())
		return EventsDto(events)
	}

	@Transactional
	override fun createOne(entity: EventCreateUpdateDto): Long {
		val event = with(entity) {
			Event(
				author = usersRepository.getOne(authorId), // TODO: load from securityContext
				name = name,
				description = description,
				dateStartUtc = date.start,
				dateEndInclusiveUtc = date.endInclusive,
				price = entryFee,
				photoUri = photoUri,
				place = null, // TODO
				tags = tagsRepository.saveAll(entity.tags.map(Tag::newInstance)).toSet()
			)
		}
		return eventsRepository.save(event).id
	}

	@Transactional(readOnly = true)
	override fun retrieveOne(id: Long): EventDto = eventsRepository.getOne(id).toDto()

	override fun updateOne(id: Long, entity: EventCreateUpdateDto) {
		val event = eventsRepository.getOne(id)
		event.apply {
			name = entity.name
			description = entity.description
			dateStartUtc = entity.date.start
			dateEndInclusiveUtc = entity.date.endInclusive
			price = entity.entryFee
			photoUri = entity.photoUri
			place = null // TODO
			tags = tagsRepository.saveAll(entity.tags.map(Tag::newInstance)).toSet()
		}
		eventsRepository.save(event)
	}

	override fun deleteOne(id: Long) {
		val event = eventsRepository.getOne(id)
		event.deleted = true
		eventsRepository.save(event)
	}

	override fun rateOne(id: Long, rate: RateDto): ResourceInfoDto<Long> {
		TODO("Not yet implemented")
	}

	override fun reportOne(id: Long, report: ReportDto): ResourceInfoDto<Long> {
		TODO("Not yet implemented")
	}
}