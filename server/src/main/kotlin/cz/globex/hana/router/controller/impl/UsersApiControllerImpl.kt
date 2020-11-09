package cz.globex.hana.router.controller.impl

import cz.globex.hana.core.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [UsersApiController.PATH])
class UsersApiControllerImpl(daoProvider: DaoProvider) : UsersApiController {
	private val usersDao = daoProvider.usersDao

	override fun retrieveMultiple(filters: UserFiltersDto): ResponseEntity<UsersDto> {
		TODO("Not yet implemented")
	}

	override fun create(entity: UserCreateUpdateDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	override fun retrieve(id: Int): ResponseEntity<UserDto> {
		TODO("Not yet implemented")
	}

	override fun update(id: Int, entity: UserCreateUpdateDto): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun delete(id: Int): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun report(id: Int, report: ReportDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}
}