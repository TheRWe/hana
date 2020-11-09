package cz.globex.hana.router.controller.action

import cz.globex.hana.core.dto.*
import org.springframework.http.*

fun interface RetrieveEntityAction<R : EntityDto> {
	fun retrieveEntity(id: Int): ResponseEntity<R>
}