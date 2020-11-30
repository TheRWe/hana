package cz.globex.hana.core.dao.action.general

fun interface DeleteDaoAction<ID : Comparable<ID>> {
	fun deleteOne(id: ID)
}