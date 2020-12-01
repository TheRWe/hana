package cz.globex.hana.router.util

import cz.globex.hana.common.dto.*
import org.springframework.http.*
import org.springframework.web.servlet.support.*

object ResponseEntities {
	fun <T : Comparable<T>> created(id: T): ResponseEntity<ResourceInfoDto<T>> {
		val location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path(PathNodes.ID)
			.buildAndExpand(id)
			.toUri()
		return ResponseEntity.created(location).body(ResourceInfoDto(id, location.toASCIIString()))
	}
}