package cz.globex.hana.router.controller

import cz.globex.hana.common.dto.*
import cz.globex.hana.router.controller.action.general.*
import cz.globex.hana.router.controller.action.specific.*

internal interface UsersApiController :
	RetrieveMultipleAction<UserFiltersDto, UsersDto>,
	CreateAction<UserCreateUpdateDto, Long>,
	RetrieveAction<UserDto, Long>,
	UpdateAction<UserCreateUpdateDto, Long>,
	DeleteAction<Long>,
	ReportAction<Long> {

	companion object {
		const val PATH: String = ApiController.PATH + "/users"
	}
}