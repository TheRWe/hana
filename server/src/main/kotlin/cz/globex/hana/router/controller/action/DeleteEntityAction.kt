package cz.globex.hana.router.controller.action

import org.springframework.http.*

fun interface DeleteEntityAction {
	fun deleteEntity(id: Int): ResponseEntity<Unit>
}