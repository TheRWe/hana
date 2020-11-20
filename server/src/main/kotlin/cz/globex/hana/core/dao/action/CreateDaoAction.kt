package cz.globex.hana.core.dao.action

import cz.globex.hana.common.dto.*

fun interface CreateDaoAction<T : EntityCreateDto> {
	fun createOne(entity: T): Long
}