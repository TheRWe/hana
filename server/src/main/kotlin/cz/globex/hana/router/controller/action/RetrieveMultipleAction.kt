package cz.globex.hana.router.controller.action

import cz.globex.hana.core.dto.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

fun interface RetrieveMultipleAction<T : EntityFiltersDto, R : EntitiesDto> {
	@GetMapping
	fun retrieveMultiple(filters: T): ResponseEntity<R>
}