package cz.globex.hana.router.util

import cz.globex.hana.common.dto.*
import cz.globex.hana.router.exception.*
import org.springframework.data.domain.*
import org.springframework.http.*

internal fun PaginationDto.toPageable(): Pageable {
	checkValidity()

	return if (pageStart == null || pageSize == null) {
		Pageable.unpaged()
	} else {
		PageRequest.of(pageStart!!, pageSize!!)
	}
}

internal fun PaginationDto.checkValidity() {
	val pageStartIsNull = pageStart == null
	if (pageStartIsNull == (pageSize == null)) return

	throw ParamsCombinationRequiredException.getInstance(HttpStatus.BAD_REQUEST, this)
}