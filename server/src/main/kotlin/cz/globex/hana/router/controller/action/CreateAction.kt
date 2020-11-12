package cz.globex.hana.router.controller.action

import cz.globex.hana.core.dao.action.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.*

fun interface CreateAction<T : EntityCreateDto> {
	@PostMapping
	fun createOne(@RequestBody entity: T): ResponseEntity<ResourceInfoDto>

	fun CreateDaoAction<T>.createOneAndWrap(entity: T): ResponseEntity<ResourceInfoDto> {
		val entityId = createOne(entity)
		val location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{${PathVariables.ID}}")
			.buildAndExpand(entityId)
			.toUri()
		return ResponseEntity.created(location).body(ResourceInfoDto(entityId, location))
	}
}