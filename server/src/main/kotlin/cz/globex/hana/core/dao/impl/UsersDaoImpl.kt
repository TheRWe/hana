package cz.globex.hana.core.dao.impl

import cz.globex.hana.core.dao.*
import cz.globex.hana.core.dto.*
import org.springframework.context.annotation.*
import org.springframework.data.domain.*

@Configuration
class UsersDaoImpl : UsersDao {
	override fun retrieveMultiple(filters: UserFiltersDto, pageable: Pageable): UsersDto {
		TODO("Not yet implemented")
	}

	override fun createOne(entity: UserCreateUpdateDto): Int {
		TODO("Not yet implemented")
	}

	override fun retrieveOneOrNull(id: Int): UserDto? {
		TODO("Not yet implemented")
	}
}