package cz.globex.hana.router.controller.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.*
import cz.globex.hana.router.controller.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.*

@RestController
@RequestMapping(path = [AdsApiController.PATH])
internal class AdsApiControllerImpl private constructor(
	private val requestUtils: RequestUtils,
	daoProvider: DaoProvider,
) : AdsApiController {
	private val adsDao = daoProvider.adsDao

	@PostMapping
	override fun createAd(
		@RequestBody ad: AdCreateReplaceDto,
	): ResponseEntity<ResourceInfoDto<Long>> {
		val resourceInfo = adsDao.createAdvertisable(ad, requestUtils.getActualUserId())
		return ResponseEntities.created(resourceInfo)
	}

	@GetMapping(PathNodes.ID)
	override fun getAd(@PathVariable(PathVariables.ID) id: Long) = adsDao.getAdvertisable(id)

	@GetMapping
	override fun getAds(filters: AdFiltersDto, pagination: PaginationDto): AdsDto {
		return adsDao.getAdvertisables(filters, pagination.toPageable())
	}

	@PutMapping(PathNodes.ID)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	override fun replaceAd(
		@PathVariable(PathVariables.ID) id: Long,
		@RequestBody ad: AdCreateReplaceDto,
	) {
		adsDao.replaceAdvertisable(id, ad)
	}

	@DeleteMapping(PathNodes.ID)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	override fun deleteAd(@PathVariable(PathVariables.ID) id: Long) = adsDao.deleteAdvertisable(id)

	@PostMapping(PathNodes.ID + PathNodes.RATINGS)
	override fun createRating(
		@PathVariable(PathVariables.ID) adId: Long,
		@RequestBody rating: RatingCreateReplaceDto,
	): ResponseEntity<ResourceInfoDto<Long>> {
		val resourceInfo = adsDao.createRating(rating, requestUtils.getActualUserId(), adId)
		return ResponseEntities.created(resourceInfo)
	}

	@GetMapping(PathNodes.ID + PathNodes.RATINGS + PathNodes.RATE_ID)
	override fun getRating(
		@PathVariable(PathVariables.ID) adId: Long,
		@PathVariable(PathVariables.RATE_ID) ratingId: Long,
	): RatingDto {
		return adsDao.getRating(id = ratingId, advertisableId = adId)
	}
}