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
internal class AdsDaoImpl protected constructor(
	private val adsRepository: AdsRepository,
	private val usersRepository: UsersRepository,
	private val tagsRepository: TagsRepository,
) : AdsDao {
	@Transactional(readOnly = true)
	override fun retrieveMultiple(filters: AdFiltersDto, pageable: Pageable): AdsDto {
		val ads: Set<AdDto> = adsRepository
			.findAll(pageable)
			.get()
			.map(Ad::toDto)
			.collect(Collectors.toSet())
		return AdsDto(ads)
	}

	@Transactional
	override fun createOne(entity: AdCreateUpdateDto): Long {
		val ad = with(entity) {
			Ad(
				author = usersRepository.getOne(authorId), // TODO: load from securityContext
				name = name,
				description = description,
				type = type,
				price = payout,
				photoUri = photoUri,
				place = null, // TODO
				tags = tagsRepository.saveAll(entity.tags.map(Tag::newInstance)).toSet()
			)
		}
		return adsRepository.save(ad).id
	}

	@Transactional(readOnly = true)
	override fun retrieveOne(id: Long): AdDto = adsRepository.getOne(id).toDto()

	override fun updateOne(id: Long, entity: AdCreateUpdateDto) {
		val ad = adsRepository.getOne(id)
		ad.apply {
			name = entity.name
			description = entity.description
			price = entity.payout
			type = entity.type
			photoUri = entity.photoUri
			place = null // TODO
			tags = tagsRepository.saveAll(entity.tags.map(Tag::newInstance)).toSet()
			isActual = entity.isActual
		}
		adsRepository.save(ad)
	}

	override fun deleteOne(id: Long) {
		val ad = adsRepository.getOne(id)
		ad.deleted = true
		adsRepository.save(ad)
	}

	override fun rateOne(id: Long, rate: RateDto): ResourceInfoDto<Long> {
		TODO("Not yet implemented")
	}

	override fun reportOne(id: Long, report: ReportDto): ResourceInfoDto<Long> {
		TODO("Not yet implemented")
	}
}