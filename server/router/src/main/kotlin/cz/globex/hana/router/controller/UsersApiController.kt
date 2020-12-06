package cz.globex.hana.router.controller

import cz.globex.hana.common.dto.*
import org.springframework.http.*

internal interface UsersApiController {
	companion object {
		const val PATH: String = ApiController.PATH + "/users"
	}

//	fun createUser(user: UserCreateReplaceDto): ResponseEntity<ResourceInfoDto<Long>>

	fun getUser(id: Long): UserDto

	fun getUsers(filters: UserFiltersDto, pagination: PaginationDto): UsersDto

//	fun replaceUser(id: Long, user: UserCreateReplaceDto)

//	fun deleteUser(id: Long)
}