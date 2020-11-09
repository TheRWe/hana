package cz.globex.hana.router.controller.action

import cz.globex.hana.core.dto.*
import org.springframework.http.*

fun interface CreateEntityAction<T : EntityCreateDto> {
	fun createEntity(entity: T): ResponseEntity<ResourceInfoDto>
}