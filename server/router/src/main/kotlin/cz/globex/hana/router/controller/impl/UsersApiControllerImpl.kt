package cz.globex.hana.router.controller.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.*
import cz.globex.hana.router.controller.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [UsersApiController.PATH])
internal class UsersApiControllerImpl private constructor(
	daoProvider: DaoProvider,
) : UsersApiController {
	private val usersDao = daoProvider.usersDao

	@PostMapping
	override fun createUser(
		@RequestBody user: UserCreateReplaceDto,
	): ResponseEntity<ResourceInfoDto<Long>> {
		return ResponseEntities.created(usersDao.createUser(user))
	}

	@GetMapping(path = [PathNodes.ID])
	override fun getUser(@PathVariable(PathVariables.ID) id: Long) = usersDao.getUser(id)

	@GetMapping
	override fun getUsers(filters: UserFiltersDto, pagination: PaginationDto): UsersDto {
		return usersDao.getUsers(filters, pagination.toPageable())
	}

	@PutMapping(path = [PathNodes.ID])
	@ResponseStatus(HttpStatus.NO_CONTENT)
	override fun replaceUser(
		@PathVariable(PathVariables.ID) id: Long,
		@RequestBody user: UserCreateReplaceDto,
	) {
		usersDao.replaceUser(id, user)
	}

	@DeleteMapping(path = [PathNodes.ID])
	@ResponseStatus(HttpStatus.NO_CONTENT)
	override fun deleteUser(@PathVariable(PathVariables.ID) id: Long) = usersDao.deleteUser(id)
}