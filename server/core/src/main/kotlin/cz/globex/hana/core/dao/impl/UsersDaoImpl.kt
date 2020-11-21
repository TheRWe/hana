package cz.globex.hana.core.dao.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.*
import org.springframework.context.annotation.*
import org.springframework.data.domain.*

@Configuration
class UsersDaoImpl : UsersDao {
	override fun retrieveMultiple(filters: UserFiltersDto, pageable: Pageable): UsersDto {
		TODO("Not yet implemented")
	}

	override fun createOne(entity: UserCreateUpdateDto): Long {
		TODO("Not yet implemented")
	}

	override fun retrieveOneOrNull(id: Long): UserDto? {
		TODO("Not yet implemented")
	}
}