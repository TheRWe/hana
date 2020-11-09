package cz.globex.hana.router.controller.action

import cz.globex.hana.core.dto.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

fun interface RateAction {
	@PostMapping(path = ["/{${PathVariables.ID}}/rate"])
	fun rate(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody rate: RateDto
	): ResponseEntity<ResourceInfoDto>
}