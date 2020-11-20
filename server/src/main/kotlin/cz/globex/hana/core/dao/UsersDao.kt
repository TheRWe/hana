package cz.globex.hana.core.dao

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.action.*

interface UsersDao :
	RetrieveMultipleDaoAction<UserFiltersDto, UsersDto>,
	CreateDaoAction<UserCreateUpdateDto>,
	RetrieveDaoAction<UserDto>