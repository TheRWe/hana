package cz.globex.hana.router.controller.action

import cz.globex.hana.core.dto.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

fun interface RetrieveEntityAction<R : EntityDto> {
	@GetMapping(path = ["/{${PathVariables.ID}}"])
	fun retrieveEntity(@PathVariable(PathVariables.ID) id: Int): ResponseEntity<R>
}