package cz.globex.hana.router.controller.action.general

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.action.general.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

internal fun interface RetrieveAction<R : EntityDto, ID : Comparable<ID>> {
	@GetMapping(path = ["/{${PathVariables.ID}}"])
	fun retrieveOne(@PathVariable(PathVariables.ID) id: ID): ResponseEntity<R>

	fun RetrieveDaoAction<R, ID>.retrieveOneAndWrap(id: ID): ResponseEntity<R> {
		return ResponseEntity.ok().body(retrieveOne(id))
	}
}