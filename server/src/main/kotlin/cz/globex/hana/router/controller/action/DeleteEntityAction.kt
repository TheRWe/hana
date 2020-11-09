package cz.globex.hana.router.controller.action

import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

fun interface DeleteEntityAction {
	@DeleteMapping(path = ["/{${PathVariables.ID}}"])
	fun deleteEntity(@PathVariable(PathVariables.ID) id: Int): ResponseEntity<Unit>
}