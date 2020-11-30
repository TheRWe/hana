package cz.globex.hana.router.controller.action.specific

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.action.specific.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

internal fun interface RateAction<ID : Comparable<ID>> {
	@PostMapping(path = ["/{${PathVariables.ID}}/rate"])
	fun rateOne(
		@PathVariable(PathVariables.ID) id: ID,
		@RequestBody rate: RateDto,
	): ResponseEntity<ResourceInfoDto<ID>>

	fun RateDaoAction<ID>.rateOneAndWrap(
		id: ID,
		rate: RateDto,
	): ResponseEntity<ResourceInfoDto<ID>> {
		val rateEntity = rateOne(id, rate)
		TODO("add location header (and endpoints to get rate/rates)")
	}
}