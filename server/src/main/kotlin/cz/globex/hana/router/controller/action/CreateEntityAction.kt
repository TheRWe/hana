package cz.globex.hana.router.controller.action

import cz.globex.hana.core.dto.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

fun interface CreateEntityAction<T : EntityCreateDto> {
	@PostMapping
	fun createEntity(@RequestBody entity: T): ResponseEntity<ResourceInfoDto>
}