package cz.globex.hana.core.dao.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.impl.*
import org.springframework.data.domain.*
import org.springframework.stereotype.*
import org.springframework.transaction.annotation.*
import java.util.stream.*
import javax.persistence.*

@Component
internal class AdsDaoImpl protected constructor(
	private val adsRepository: AdsRepository,
	private val usersRepository: UsersRepository,
	private val tagsRepository: TagsRepository,
	private val adRatingsRepository: AdRatingsRepository
) : AdsDao {
	@Transactional
	override fun createAdvertisable(advertisableDto: AdCreateReplaceDto, authorId: Long): Long {
		val ad = with(advertisableDto) {
			Ad(
				author = usersRepository.getByIdAndIsDeletedFalse(authorId),
				name = name,
				description = description,
				type = type,
				price = payout,
				photoUri = photoUri,
				place = null, // TODO
				tags = tagsRepository.saveAll(advertisableDto.tags.map { Tag(it) }).toSet()
			)
		}
		return adsRepository.save(ad).id_safe
	}

	@Transactional(readOnly = true)
	override fun getAdvertisables(filters: AdFiltersDto, pageable: Pageable): AdsDto {
		val ads: Set<AdDto> = adsRepository
			.findAllByIsDeletedFalse(pageable)
			.get()
			.map(Ad::toDto)
			.collect(Collectors.toSet())
		return AdsDto(ads)
	}

	@Transactional(readOnly = true)
	override fun getAdvertisable(id: Long): AdDto {
		return adsRepository.getByIdAndIsDeletedFalse(id).toDto()
	}

	override fun replaceAdvertisable(id: Long, advertisableDto: AdCreateReplaceDto) {
		val ad = adsRepository.getByIdAndIsDeletedFalse(id)
		ad.apply {
			name = advertisableDto.name
			description = advertisableDto.description
			price = advertisableDto.payout
			type = advertisableDto.type
			photoUri = advertisableDto.photoUri
			place = null // TODO
			tags = tagsRepository.saveAll(advertisableDto.tags.map { Tag(it) }).toSet()
			isActual = advertisableDto.isActual
		}
		adsRepository.save(ad)
	}

	@Transactional
	override fun deleteAdvertisable(id: Long) {
		if (!adsRepository.existsByIdAndIsDeletedFalse(id)) throw EntityNotFoundException()
		adsRepository.deleteById(id)
	}

	override fun createRating(
		ratingDto: RatingCreateReplaceDto,
		authorId: Long,
		advertisableId: Long,
	): Long {
		val rating =
			AdRating(
				usersRepository.getByIdAndIsDeletedFalse(authorId),
				adsRepository.getByIdAndIsDeletedFalse(advertisableId),
				ratingDto.score
			)
		return adRatingsRepository.save(rating).id_safe
	}

	override fun getRating(id: Long, advertisableId: Long): RatingDto {
		return adRatingsRepository
			.getByIdAndAdvertisableId(id = id, advertisableId = advertisableId)
			.toDto()
	}
}