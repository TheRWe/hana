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
				author = usersRepository.getOne(authorId),
//				author = usersRepository.getByIdAndIsDeletedFalse(authorId),
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
//		val ads: Set<AdDto> = adsRepository
//			.findAllByIsDeletedFalse(pageable)
//			.get()
//			.map(Ad::toDto)
//			.collect(Collectors.toSet())
//		return AdsDto(ads)

		val createdStartUtc = filters.createdStartUtc?.let { LocalDateTime.parse(it, DateTimeFormatter.ISO_LOCAL_DATE_TIME) }
		val createdEndInclusiveUtc = filters.createdEndInclusiveUtc?.let { LocalDateTime.parse(it, DateTimeFormatter.ISO_LOCAL_DATE_TIME) }
		if (createdStartUtc != null && createdEndInclusiveUtc != null && createdStartUtc.isAfter(createdEndInclusiveUtc)) {
			throw ResponseStatusException(HttpStatus.BAD_REQUEST)
		}

		var adsStream: Stream<Ad> = adsRepository.stream().filter { !it.isDeleted }

		// TODO: these operations should be done on the db level
		with(filters) {
			if (authorId != null) adsStream	= adsStream.filter { authorId == it.author_safe.id }
			if (isActual != null) adsStream = adsStream.filter { isActual == it.isActual }
			if (salaryStart != null) adsStream = adsStream.filter { salaryStart!! <= it.price }
			if (salaryEndInclusive != null) adsStream = adsStream.filter { salaryEndInclusive!! >= it.price }
			if (tagName != null) adsStream = adsStream.filter { tagName!!.map { tag -> tag.toLowerCase() }.union(it.tags.map { tag -> tag.name.toLowerCase() }).size == tagName!!.size }
			if (type != null) adsStream = adsStream.filter { type == it.type }
			if (createdStartUtc != null) adsStream = adsStream.filter { it.createdUtc_safe.isAfter(createdStartUtc) || it.createdUtc_safe.isEqual(createdStartUtc) }
			if (createdEndInclusiveUtc != null) adsStream = adsStream.filter { it.createdUtc_safe.isBefore(createdEndInclusiveUtc) || it.createdUtc_safe.isEqual(createdEndInclusiveUtc) }
		}
		val ads: List<Ad> = with(pageable) {
			if (isPaged) {
				adsStream
					.limit((pageNumber * pageSize).toLong())
					.toList()
					.drop((pageNumber - 1) * pageSize)
			} else {
				adsStream.toList()
			}
		}
		return AdsDto(ads.mapTo(mutableSetOf(), Ad::toDto))
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
//				usersRepository.getByIdAndIsDeletedFalse(authorId),
				usersRepository.getOne(authorId),
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