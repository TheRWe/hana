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

	override fun retrieveOne(id: Long): ResponseEntity<UserDto> = usersDao.retrieveOneAndWrap(id)

	override fun updateOne(id: Long, entity: UserCreateUpdateDto): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun deleteOne(id: Long): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	override fun reportOne(id: Long, report: ReportDto): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}
}