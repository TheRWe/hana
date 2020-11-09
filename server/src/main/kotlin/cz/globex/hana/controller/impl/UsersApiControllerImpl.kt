package cz.globex.hana.controller.impl

import cz.globex.hana.controller.*
import cz.globex.hana.controller.dto.*
import cz.globex.hana.controller.util.*
import cz.globex.hana.core.dto.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [UsersApiController.PATH])
class UsersApiControllerImpl : UsersApiController {
	@GetMapping
	override fun retrieveUsers(reqParams: UsersRequestDto): ResponseEntity<UsersDto> {
		TODO("Not yet implemented")
	}

	@PostMapping
	override fun createUser(
		@RequestBody user: UserCreateUpdateDto
	): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}

	@GetMapping(path = ["/{${PathVariables.ID}}"])
	override fun retrieveUser(@PathVariable(PathVariables.ID) id: Int): ResponseEntity<UserDto> {
		TODO("Not yet implemented")
	}

	@PutMapping(path = ["/{${PathVariables.ID}}"])
	override fun updateUser(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody user: UserCreateUpdateDto
	): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	@DeleteMapping(path = ["/{${PathVariables.ID}}"])
	override fun deleteUser(@PathVariable(PathVariables.ID) id: Int): ResponseEntity<Unit> {
		TODO("Not yet implemented")
	}

	@PostMapping(path = ["/{${PathVariables.ID}}/report"])
	override fun reportUser(
		@PathVariable(PathVariables.ID) id: Int,
		@RequestBody report: ReportDto
	): ResponseEntity<ResourceInfoDto> {
		TODO("Not yet implemented")
	}
}