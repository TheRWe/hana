package cz.globex.hana.router.controller.action.specific

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.action.specific.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

internal fun interface ReportAction<ID : Comparable<ID>> {
	@PostMapping(path = ["/{${PathVariables.ID}}/report"])
	fun reportOne(
		@PathVariable(PathVariables.ID) id: Long,
		@RequestBody report: ReportDto,
	): ResponseEntity<ResourceInfoDto<ID>>

	fun ReportDaoAction<ID>.reportOneAndWrap(
		id: ID,
		report: ReportDto,
	): ResponseEntity<ResourceInfoDto<ID>> {
		val reportEntity = reportOne(id, report)
		TODO("add location header (and endpoints to get report/reports)")
	}
}