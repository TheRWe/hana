package cz.globex.hana.core.dao.action

import cz.globex.hana.core.dto.*

fun interface CreateDaoAction<T : EntityCreateDto> {
	fun createOne(entity: T): Int
}