package cz.globex.hana.router.controller

import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.action.*
import cz.globex.hana.router.dto.*

interface UsersApiController :
	RetrieveEntitiesAction<UsersRequestDto, UsersDto>,
	CreateEntityAction<UserCreateUpdateDto>,
	RetrieveEntityAction<UserDto>,
	UpdateEntityAction<UserCreateUpdateDto>,
	DeleteEntityAction,
	ReportEntityAction {

	companion object {
		const val PATH: String = ApiController.PATH + "/users"
	}
}