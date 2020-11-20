package cz.globex.hana.router.controller.action

import cz.globex.hana.common.dto.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

fun interface RateAction {
	@PostMapping(path = ["/{${PathVariables.ID}}/rate"])
	fun rateOne(
		@PathVariable(PathVariables.ID) id: Long,
		@RequestBody rate: RateDto
	): ResponseEntity<ResourceInfoDto>
}