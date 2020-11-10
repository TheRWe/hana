package cz.globex.hana.core.dao.action

import cz.globex.hana.core.dto.*
import org.springframework.data.domain.*

fun interface RetrieveMultipleDaoAction<T : EntityFiltersDto, R : EntitiesDto> {
	fun retrieveMultiple(filters: T, pageable: Pageable): R
}