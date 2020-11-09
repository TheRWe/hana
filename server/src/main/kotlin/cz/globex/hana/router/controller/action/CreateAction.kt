package cz.globex.hana.router.controller.action

import cz.globex.hana.core.dto.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

fun interface CreateAction<T : EntityCreateDto> {
	@PostMapping
	fun create(@RequestBody entity: T): ResponseEntity<ResourceInfoDto>
}