package cz.globex.hana.router.controller.impl

import cz.globex.hana.core.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.*
import cz.globex.hana.router.dto.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [UsersApiController.PATH])
class UsersApiControllerImpl(daoProvider: DaoProvider) : UsersApiController {
	private val usersDao = daoProvider.usersDao

	override fun retrieveEntities(reqParams: UsersRequestDto): ResponseEntity<UsersDto> {
		TODO("Not yet implemented")
	}

	override fun createEntity(entity: UserCreateUpdateDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	override fun retrieveEntity(id: Int): ResponseEntity<UserDto> {
		TODO("Not yet implemented")
	}

	override fun updateEntity(id: Int, entity: UserCreateUpdateDto): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun deleteEntity(id: Int): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun reportEntity(id: Int, report: ReportDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}
}