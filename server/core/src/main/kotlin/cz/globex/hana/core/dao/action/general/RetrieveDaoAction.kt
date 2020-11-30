package cz.globex.hana.core.dao.action.general

import cz.globex.hana.common.dto.*
import org.springframework.transaction.annotation.*

fun interface RetrieveDaoAction<R : EntityDto, ID : Comparable<ID>> {
	fun retrieveOne(id: ID): R
}