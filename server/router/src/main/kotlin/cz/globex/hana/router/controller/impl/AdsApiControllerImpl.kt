package cz.globex.hana.router.controller.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.*
import cz.globex.hana.router.controller.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.*
import javax.persistence.*

@RestController
@RequestMapping(path = [AdsApiController.PATH])
internal class AdsApiControllerImpl private constructor(
	daoProvider: DaoProvider
) : AdsApiController {
	private val adsDao = daoProvider.adsDao

	override fun retrieveMultiple(
		filters: AdFiltersDto,
		pagination: PaginationDto
	): ResponseEntity<AdsDto> {
		return adsDao.retrieveMultipleAndWrap(filters, pagination)
	}

	override fun createOne(entity: AdCreateUpdateDto): ResponseEntity<ResourceInfoDto<Long>> {
		return adsDao.createOneAndWrap(entity)
	}

	override fun retrieveOne(id: Long): ResponseEntity<AdDto> = adsDao.retrieveOneAndWrap(id)

	override fun updateOne(id: Long, entity: AdCreateUpdateDto): ResponseEntity<Unit> {
		return adsDao.updateOneAndWrap(id, entity)
	}

	override fun deleteOne(id: Long): ResponseEntity<Unit> = adsDao.deleteOneAndWrap(id)

	override fun rateOne(id: Long, rate: RateDto): ResponseEntity<ResourceInfoDto<Long>> {
		return adsDao.rateOneAndWrap(id, rate)
	}

	override fun reportOne(id: Long, report: ReportDto): ResponseEntity<ResourceInfoDto<Long>> {
		return adsDao.reportOneAndWrap(id, report)
	}
}