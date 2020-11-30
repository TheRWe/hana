package cz.globex.hana.core.dao.action.specific

import cz.globex.hana.common.dto.*

fun interface RateDaoAction<ID : Comparable<ID>> {
	fun rateOne(id: ID, rate: RateDto): ResourceInfoDto<ID>
}