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
internal class StockExchangesDaoImpl protected constructor(
	private val stockExchangesRepository: StockExchangesRepository,
	private val usersRepository: UsersRepository,
	private val tagsRepository: TagsRepository,
	private val stockExchangeRatingsRepository: StockExchangeRatingsRepository
) : StockExchangesDao {
	@Transactional(readOnly = true)
	override fun getAdvertisables(
		filters: StockExchangeFiltersDto,
		pageable: Pageable,
	): StockExchangesDto {
//		val stockExchanges: Set<StockExchangeDto> = stockExchangesRepository
//			.findAllByIsDeletedFalse(pageable)
//			.get()
//			.map(StockExchange::toDto)
//			.collect(Collectors.toSet())
//		return StockExchangesDto(stockExchanges)

		val createdStartUtc = filters.createdStartUtc?.let { LocalDateTime.parse(it, DateTimeFormatter.ISO_LOCAL_DATE_TIME) }
		val createdEndInclusiveUtc = filters.createdEndInclusiveUtc?.let { LocalDateTime.parse(it, DateTimeFormatter.ISO_LOCAL_DATE_TIME) }
		if (createdStartUtc != null && createdEndInclusiveUtc != null && createdStartUtc.isAfter(createdEndInclusiveUtc)) {
			throw ResponseStatusException(HttpStatus.BAD_REQUEST)
		}

		var stockExchangesStream: Stream<StockExchange> = stockExchangesRepository.stream().filter { !it.isDeleted }

		// TODO: these operations should be done on the db level
		with(filters) {
			if (authorId != null) stockExchangesStream	= stockExchangesStream.filter { authorId == it.author_safe.id }
			if (isActual != null) stockExchangesStream = stockExchangesStream.filter { isActual == it.isActual }
			if (costStart != null) stockExchangesStream = stockExchangesStream.filter { costStart!! <= it.price }
			if (costEndInclusive != null) stockExchangesStream = stockExchangesStream.filter { costEndInclusive!! >= it.price }
			if (tagName != null) stockExchangesStream = stockExchangesStream.filter { tagName!!.map { tag -> tag.toLowerCase() }.union(it.tags.map { tag -> tag.name.toLowerCase() }).size == tagName!!.size }
			if (type != null) stockExchangesStream = stockExchangesStream.filter { type == it.type }
			if (createdStartUtc != null) stockExchangesStream = stockExchangesStream.filter { it.createdUtc_safe.isAfter(createdStartUtc) || it.createdUtc_safe.isEqual(createdStartUtc) }
			if (createdEndInclusiveUtc != null) stockExchangesStream = stockExchangesStream.filter { it.createdUtc_safe.isBefore(createdEndInclusiveUtc) || it.createdUtc_safe.isEqual(createdEndInclusiveUtc) }
		}
		val stockExchanges: List<StockExchange> = with(pageable) {
			if (isPaged) {
				stockExchangesStream
					.limit((pageNumber * pageSize).toLong())
					.toList()
					.drop((pageNumber - 1) * pageSize)
			} else {
				stockExchangesStream.toList()
			}
		}
		return StockExchangesDto(stockExchanges.mapTo(mutableSetOf(), StockExchange::toDto))
	}

	@Transactional
	override fun createAdvertisable(
		advertisableDto: StockExchangeCreateReplaceDto,
		authorId: Long,
	): Long {
		val stockExchange = with(advertisableDto) {
			StockExchange(
//				author = usersRepository.getByIdAndIsDeletedFalse(authorId),
				author = usersRepository.getOne(authorId),
				name = name,
				description = description,
				type = type,
				price = cost,
				photoUri = photoUri,
				place = null, // TODO
				tags = tagsRepository.saveAll(advertisableDto.tags.map { Tag(it) }).toSet()
			)
		}
		return stockExchangesRepository.save(stockExchange).id_safe
	}

	@Transactional(readOnly = true)
	override fun getAdvertisable(id: Long): StockExchangeDto {
		return stockExchangesRepository.getByIdAndIsDeletedFalse(id).toDto()
	}

	override fun replaceAdvertisable(id: Long, advertisableDto: StockExchangeCreateReplaceDto) {
		val stockExchange = stockExchangesRepository.getByIdAndIsDeletedFalse(id)
		stockExchange.apply {
			name = advertisableDto.name
			description = advertisableDto.description
			price = advertisableDto.cost
			type = advertisableDto.type
			photoUri = advertisableDto.photoUri
			place = null // TODO
			tags = tagsRepository.saveAll(advertisableDto.tags.map { Tag(it) }).toMutableSet()
			isActual = advertisableDto.isActual
		}
		stockExchangesRepository.save(stockExchange)
	}

	@Transactional
	override fun deleteAdvertisable(id: Long) {
		if (!stockExchangesRepository.existsByIdAndIsDeletedFalse(id)) throw EntityNotFoundException()
		return stockExchangesRepository.deleteById(id)
	}

	override fun createRating(
		ratingDto: RatingCreateReplaceDto,
		authorId: Long,
		advertisableId: Long,
	): Long {
		val rating =
			StockExchangeRating(
//				usersRepository.getByIdAndIsDeletedFalse(authorId),
				usersRepository.getOne(authorId),
				stockExchangesRepository.getByIdAndIsDeletedFalse(advertisableId),
				ratingDto.score
			)
		return stockExchangeRatingsRepository.save(rating).id_safe
	}

	override fun getRating(id: Long, advertisableId: Long): RatingDto {
		return stockExchangeRatingsRepository
			.getByIdAndAdvertisableId(id = id, advertisableId = advertisableId)
			.toDto()
	}
}