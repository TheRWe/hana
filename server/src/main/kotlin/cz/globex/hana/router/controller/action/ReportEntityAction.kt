package cz.globex.hana.router.controller.action

import cz.globex.hana.core.dto.*
import org.springframework.http.*

fun interface ReportEntityAction {
	fun reportEntity(id: Int, report: ReportDto): ResponseEntity<ResourceInfoDto>
}