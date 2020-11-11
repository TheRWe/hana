package cz.globex.hana.router.controller.action

import cz.globex.hana.core.dao.action.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

fun interface RetrieveAction<R : EntityDto> {
	@GetMapping(path = ["/{${PathVariables.ID}}"])
	fun retrieveOne(@PathVariable(PathVariables.ID) id: Int): ResponseEntity<R>

	fun RetrieveDaoAction<R>.retrieveOneAndWrap(id: Int): ResponseEntity<R> {
		val entity = retrieveOneOrNull(id)
		return if (entity != null) {
			ResponseEntity.ok().body(entity)
		} else {
			ResponseEntity.notFound().build()
		}
	}
}