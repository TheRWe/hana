package cz.globex.hana.core.dao

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.action.general.*
import cz.globex.hana.core.dao.action.specific.*
import cz.globex.hana.database.entity.impl.*

interface UsersDao :
	RetrieveMultipleDaoAction<UserFiltersDto, UsersDto>,
	CreateDaoAction<UserCreateUpdateDto, Long>,
	RetrieveDaoAction<UserDto, Long>,
	UpdateDaoAction<UserCreateUpdateDto, Long>,
	DeleteDaoAction<Long>,
	ReportDaoAction<Long> {

	fun AdvertisablesDao<*, *, *, *, *>.getUser(id: Long): User {
		return getUserOrNull(id) ?: TODO("user not exists")
	}

	fun AdvertisablesDao<*, *, *, *, *>.getUserOrNull(id: Long): User?
}