package cz.globex.hana.router.controller.impl

import cz.globex.hana.core.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.*
import cz.globex.hana.router.dto.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [UsersApiController.PATH])
class UsersApiControllerImpl(daoProvider: DaoProvider) : UsersApiController {
	private val usersDao = daoProvider.usersDao

	@GetMapping
	override fun retrieveEntities(reqParams: UsersRequestDto): ResponseEntity<UsersDto> {
		TODO("Not yet implemented")
	}

	@PostMapping
	override fun createEntity(
		@RequestBody entity: UserCreateUpdateDto
	): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	@GetMapping(path = ["/{${PathVariables.ID}}"])
	override fun retrieveEntity(@PathVariable(PathVariables.ID) id: Int): ResponseEntity<UserDto> {
		TODO("Not yet implemented")
	}

	@PutMapping(path = ["/{${PathVariables.ID}}"])
	override fun updateEntity(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody entity: UserCreateUpdateDto
	): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	@DeleteMapping(path = ["/{${PathVariables.ID}}"])
	override fun deleteEntity(id: Int): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	@PostMapping(path = ["/{${PathVariables.ID}}/report"])
	override fun reportEntity(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody report: ReportDto
	): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}
}