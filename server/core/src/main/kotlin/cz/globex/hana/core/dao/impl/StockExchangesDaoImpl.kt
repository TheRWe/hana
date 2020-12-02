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
		val stockExchanges: Set<StockExchangeDto> = stockExchangesRepository
			.findAllByIsDeletedFalse(pageable)
			.get()
			.map(StockExchange::toDto)
			.collect(Collectors.toSet())
		return StockExchangesDto(stockExchanges)
	}

	@Transactional
	override fun createAdvertisable(
		advertisableDto: StockExchangeCreateReplaceDto,
		authorId: Long,
	): Long {
		val stockExchange = with(advertisableDto) {
			StockExchange(
				author = usersRepository.getByIdAndIsDeletedFalse(authorId),
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
			tags = tagsRepository.saveAll(advertisableDto.tags.map { Tag(it) }).toSet()
			isActual = advertisableDto.isActual
		}
	}

	override fun deleteAdvertisable(id: Long) {
		val stockExchange = stockExchangesRepository.getByIdAndIsDeletedFalse(id)
		stockExchange.isDeleted = true
		stockExchangesRepository.save(stockExchange)
	}

	override fun createRating(
		ratingDto: RatingCreateReplaceDto,
		authorId: Long,
		advertisableId: Long,
	): Long {
		val rating =
			StockExchangeRating(
				usersRepository.getByIdAndIsDeletedFalse(authorId),
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