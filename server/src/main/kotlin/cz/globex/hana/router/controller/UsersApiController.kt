package cz.globex.hana.router.controller

import cz.globex.hana.common.dto.*
import cz.globex.hana.router.controller.action.*

interface UsersApiController :
	RetrieveMultipleAction<UserFiltersDto, UsersDto>,
	CreateAction<UserCreateUpdateDto>,
	RetrieveAction<UserDto>,
	UpdateAction<UserCreateUpdateDto>,
	DeleteAction,
	ReportAction {

	companion object {
		const val PATH: String = ApiController.PATH + "/users"
	}
}