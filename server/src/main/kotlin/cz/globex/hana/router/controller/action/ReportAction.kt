package cz.globex.hana.router.controller.action

import cz.globex.hana.core.dto.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

fun interface ReportAction {
	@PostMapping(path = ["/{${PathVariables.ID}}/report"])
	fun reportOne(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody report: ReportDto
	): ResponseEntity<ResourceInfoDto>
}