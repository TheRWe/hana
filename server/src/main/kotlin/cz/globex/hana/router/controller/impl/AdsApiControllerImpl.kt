package cz.globex.hana.router.controller.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.*
import cz.globex.hana.router.controller.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [AdsApiController.PATH])
class AdsApiControllerImpl(daoProvider: DaoProvider) : AdsApiController {
	private val adsDao = daoProvider.adsDao

	override fun retrieveMultiple(
		filters: AdFiltersDto,
		pagination: PaginationDto
	): ResponseEntity<AdsDto> {
		return adsDao.retrieveMultipleAndWrap(filters, pagination)
	}

	override fun createOne(entity: AdCreateUpdateDto): ResponseEntity<ResourceInfoDto> {
		return adsDao.createOneAndWrap(entity)
	}

	override fun retrieveOne(id: Long): ResponseEntity<AdDto> = adsDao.retrieveOneAndWrap(id)

	override fun updateOne(id: Long, entity: AdCreateUpdateDto): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun deleteOne(id: Long): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun rateOne(id: Long, rate: RateDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	override fun reportOne(id: Long, report: ReportDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}
}