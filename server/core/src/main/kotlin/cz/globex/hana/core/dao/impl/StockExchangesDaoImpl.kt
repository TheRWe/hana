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
internal class StockExchangesDaoImpl protected constructor(
	private val stockExchangesRepository: StockExchangesRepository,
	private val usersRepository: UsersRepository,
	private val tagsRepository: TagsRepository,
) : StockExchangesDao {
	@Transactional(readOnly = true)
	override fun retrieveMultiple(
		filters: StockExchangeFiltersDto,
		pageable: Pageable,
	): StockExchangesDto {
		val stockExchanges: Set<StockExchangeDto> = stockExchangesRepository
			.findAll(pageable)
			.get()
			.map(StockExchange::toDto)
			.collect(Collectors.toSet())
		return StockExchangesDto(stockExchanges)
	}

	@Transactional
	override fun createOne(entity: StockExchangeCreateUpdateDto): Long {
		val stockExchange = with(entity) {
			StockExchange(
				author = usersRepository.getOne(authorId), // TODO: load from securityContext
				name = name,
				description = description,
				type = type,
				price = cost,
				photoUri = photoUri,
				place = null, // TODO
				tags = tagsRepository.saveAll(entity.tags.map(Tag::newInstance)).toSet()
			)
		}
		return stockExchangesRepository.save(stockExchange).id
	}

	@Transactional(readOnly = true)
	override fun retrieveOne(id: Long): StockExchangeDto {
		return stockExchangesRepository.getOne(id).toDto()
	}

	override fun updateOne(id: Long, entity: StockExchangeCreateUpdateDto) {
		val stockExchange = stockExchangesRepository.getOne(id)
		stockExchange.apply {
			name = entity.name
			description = entity.description
			price = entity.cost
			type = entity.type
			photoUri = entity.photoUri
			place = null // TODO
			tags = tagsRepository.saveAll(entity.tags.map(Tag::newInstance)).toSet()
			isActual = entity.isActual
		}
	}

	override fun deleteOne(id: Long) {
		val stockExchange = stockExchangesRepository.getOne(id)
		stockExchange.deleted = true
		stockExchangesRepository.save(stockExchange)
	}

	override fun rateOne(id: Long, rate: RateDto): ResourceInfoDto<Long> {
		TODO("Not yet implemented")
	}

	override fun reportOne(id: Long, report: ReportDto): ResourceInfoDto<Long> {
		TODO("Not yet implemented")
	}
}