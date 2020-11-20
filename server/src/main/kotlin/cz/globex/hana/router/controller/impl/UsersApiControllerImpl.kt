package cz.globex.hana.router.controller.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.*
import cz.globex.hana.router.controller.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [UsersApiController.PATH])
class UsersApiControllerImpl(daoProvider: DaoProvider) : UsersApiController {
	private val usersDao = daoProvider.usersDao

	override fun retrieveMultiple(
		filters: UserFiltersDto,
		pagination: PaginationDto
	): ResponseEntity<UsersDto> {
		return usersDao.retrieveMultipleAndWrap(filters, pagination)
	}

	override fun createOne(entity: UserCreateUpdateDto): ResponseEntity<ResourceInfoDto> {
		return usersDao.createOneAndWrap(entity)
	}

	override fun retrieveOne(id: Int): ResponseEntity<UserDto> = usersDao.retrieveOneAndWrap(id)

	override fun updateOne(id: Int, entity: UserCreateUpdateDto): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun deleteOne(id: Int): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun reportOne(id: Int, report: ReportDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}
}