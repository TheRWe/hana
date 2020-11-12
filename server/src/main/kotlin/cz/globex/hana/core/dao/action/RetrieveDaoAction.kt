package cz.globex.hana.core.dao.action

import cz.globex.hana.core.dto.*

fun interface RetrieveDaoAction<R : EntityDto> {
	fun retrieveOneOrNull(id: Int): R?
}