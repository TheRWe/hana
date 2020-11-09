package cz.globex.hana.router.controller.action

import cz.globex.hana.core.dto.*
import cz.globex.hana.router.dto.*
import org.springframework.http.*

fun interface RetrieveEntitiesAction<T : EntitiesRequestDto, R : EntitiesDto> {
	fun retrieveEntities(reqParams: T): ResponseEntity<R>
}