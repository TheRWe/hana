package cz.globex.hana.core.dao

import cz.globex.hana.common.dto.*
import org.springframework.data.domain.*

interface AdvertisablesDao<T : EntityDto, S : EntitiesDto, C : EntityCreateReplaceDto, F : EntityFiltersDto> {
	fun createAdvertisable(advertisableDto: C, authorId: Long): Long

	fun getAdvertisable(id: Long): T

	fun getAdvertisables(filters: F, pageable: Pageable): S

	fun replaceAdvertisable(id: Long, advertisableDto: C)

	fun deleteAdvertisable(id: Long)

	fun createRating(
		ratingDto: RatingCreateReplaceDto,
		authorId: Long,
		advertisableId: Long,
	): Long

	fun getRating(id: Long, advertisableId: Long): RatingDto
}