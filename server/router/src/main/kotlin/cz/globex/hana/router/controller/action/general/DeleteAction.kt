package cz.globex.hana.router.controller.action.general

import cz.globex.hana.core.dao.action.general.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

internal fun interface DeleteAction<ID : Comparable<ID>> {
	@DeleteMapping(path = ["/{${PathVariables.ID}}"])
	fun deleteOne(@PathVariable(PathVariables.ID) id: ID): ResponseEntity<Unit>

	fun DeleteDaoAction<ID>.deleteOneAndWrap(id: ID): ResponseEntity<Unit> {
		deleteOne(id)
		return ResponseEntity(HttpStatus.NO_CONTENT)
	}
}