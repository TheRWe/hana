package cz.globex.hana.router.controller.action

import cz.globex.hana.common.dto.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

fun interface UpdateAction<T : EntityUpdateDto> {
	@PutMapping(path = ["/{${PathVariables.ID}}"])
	fun updateOne(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody entity: T
	): ResponseEntity<Unit>
}