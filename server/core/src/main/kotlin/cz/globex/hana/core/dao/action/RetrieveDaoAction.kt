package cz.globex.hana.core.dao.action

import cz.globex.hana.common.dto.*

fun interface RetrieveDaoAction<R : EntityDto> {
	fun retrieveOneOrNull(id: Long): R?
}