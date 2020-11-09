package cz.globex.hana.router.controller.action

import cz.globex.hana.core.dto.*
import cz.globex.hana.router.dto.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

fun interface RetrieveEntitiesAction<T : EntitiesRequestDto, R : EntitiesDto> {
	@GetMapping
	fun retrieveEntities(reqParams: T): ResponseEntity<R>
}