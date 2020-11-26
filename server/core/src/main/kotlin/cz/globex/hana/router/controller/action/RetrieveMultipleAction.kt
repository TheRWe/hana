package cz.globex.hana.router.controller.action

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.action.*
import cz.globex.hana.router.exception.*
import org.springframework.data.domain.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

fun interface RetrieveMultipleAction<T : EntityFiltersDto, R : EntitiesDto> {
	@GetMapping
	fun retrieveMultiple(filters: T, pagination: PaginationDto): ResponseEntity<R>

	fun RetrieveMultipleDaoAction<T, R>.retrieveMultipleAndWrap(
		filters: T,
		pagination: PaginationDto
	): ResponseEntity<R> {
		val entities = retrieveMultiple(filters, pagination.toPageable())
		return ResponseEntity.ok().body(entities)
	}
}

private fun PaginationDto.toPageable(): Pageable {
	checkValidity()

	return if (pageStart == null || pageSize == null) {
		Pageable.unpaged()
	} else {
		PageRequest.of(pageStart!!, pageSize!!)
	}
}

private fun PaginationDto.checkValidity() {
	val pageStartIsNull = pageStart == null
	if (pageStartIsNull == (pageSize == null)) return

	throw ParamsCombinationRequiredException.getInstance(HttpStatus.BAD_REQUEST, this)
}