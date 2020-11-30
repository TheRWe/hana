package cz.globex.hana.core.dao.action.general

import cz.globex.hana.common.dto.*
import org.springframework.data.domain.*
import org.springframework.transaction.annotation.*

fun interface RetrieveMultipleDaoAction<T : EntityFiltersDto, R : EntitiesDto> {
	fun retrieveMultiple(filters: T, pageable: Pageable): R
}