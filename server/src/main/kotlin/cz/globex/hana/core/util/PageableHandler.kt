package cz.globex.hana.core.util

import org.springframework.data.domain.*

object PageableHandler {
	fun getPageable(pageStart: Int?, pageSize: Int?): Pageable {
		return if (pageStart == null || pageSize == null) {
			Pageable.unpaged()
		} else {
			PageRequest.of(pageStart, pageSize)
		}
	}
}