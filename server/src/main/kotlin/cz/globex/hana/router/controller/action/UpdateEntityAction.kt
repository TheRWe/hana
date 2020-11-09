package cz.globex.hana.router.controller.action

import cz.globex.hana.core.dto.*
import org.springframework.http.*

fun interface UpdateEntityAction<T : EntityUpdateDto> {
	fun updateEntity(id: Int, entity: T): ResponseEntity<Unit>
}