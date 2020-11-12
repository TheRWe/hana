package cz.globex.hana.core.dao

import cz.globex.hana.core.dao.action.*
import cz.globex.hana.core.dto.*

interface UsersDao :
	RetrieveMultipleDaoAction<UserFiltersDto, UsersDto>,
	CreateDaoAction<UserCreateUpdateDto>,
	RetrieveDaoAction<UserDto>