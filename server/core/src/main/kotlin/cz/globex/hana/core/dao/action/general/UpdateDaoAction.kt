package cz.globex.hana.core.dao.action.general

import cz.globex.hana.common.dto.*

fun interface UpdateDaoAction<T : EntityUpdateDto, ID : Comparable<ID>> {
	fun updateOne(id: ID, entity: T)
}