package cz.globex.hana.core.dao.action.specific

import cz.globex.hana.common.dto.*

fun interface ReportDaoAction<ID : Comparable<ID>> {
	fun reportOne(id: ID, report: ReportDto): ResourceInfoDto<ID>
}