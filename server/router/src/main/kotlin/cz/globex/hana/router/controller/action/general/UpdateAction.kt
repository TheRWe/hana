package cz.globex.hana.router.controller.action.general

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.action.general.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

internal fun interface UpdateAction<T : EntityUpdateDto, ID : Comparable<ID>> {
	@PutMapping(path = ["/{${PathVariables.ID}}"])
	fun updateOne(
		@PathVariable(PathVariables.ID) id: ID,
		@RequestBody entity: T
	): ResponseEntity<Unit>

	fun UpdateDaoAction<T, ID>.updateOneAndWrap(id: ID, entity: T): ResponseEntity<Unit> {
		updateOne(id, entity)
		return ResponseEntity(HttpStatus.NO_CONTENT)
	}
}