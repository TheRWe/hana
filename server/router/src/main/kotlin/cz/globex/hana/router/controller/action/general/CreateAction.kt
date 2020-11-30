package cz.globex.hana.router.controller.action.general

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.action.general.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.*

internal fun interface CreateAction<T : EntityCreateDto, ID : Comparable<ID>> {
	@PostMapping
	fun createOne(@RequestBody entity: T): ResponseEntity<ResourceInfoDto<ID>>

	fun CreateDaoAction<T, ID>.createOneAndWrap(entity: T): ResponseEntity<ResourceInfoDto<ID>> {
		val entityId = createOne(entity)
		val location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{${PathVariables.ID}}")
			.buildAndExpand(entityId)
			.toUri()
		val resourceInfo = ResourceInfoDto(entityId, location.toASCIIString())
		return ResponseEntity.created(location).body(resourceInfo)
	}
}