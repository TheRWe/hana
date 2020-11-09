package cz.globex.hana.router.controller

import cz.globex.hana.router.dto.*
import cz.globex.hana.core.dto.*
import org.springframework.http.*

interface UsersApiController {
	companion object {
		const val PATH: String = ApiController.PATH + "/users"
	}

	fun retrieveUsers(reqParams: UsersRequestDto): ResponseEntity<UsersDto>

	fun createUser(user: UserCreateUpdateDto): ResponseEntity<ResourceInfoDto>

	fun retrieveUser(id: Int): ResponseEntity<UserDto>

	fun updateUser(id: Int, user: UserCreateUpdateDto): ResponseEntity<Unit>

	fun deleteUser(id: Int): ResponseEntity<Unit>

	fun reportUser(id: Int, report: ReportDto): ResponseEntity<ResourceInfoDto>
}