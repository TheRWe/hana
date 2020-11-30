package cz.globex.hana.core.dao.action.general

import cz.globex.hana.common.dto.*
import org.springframework.transaction.annotation.*

fun interface CreateDaoAction<T : EntityCreateDto, ID : Comparable<ID>> {
	fun createOne(entity: T): ID
}