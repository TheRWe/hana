package cz.globex.hana.core.dao

import cz.globex.hana.common.dto.*
import org.springframework.data.domain.*

interface UsersDao {
//	fun createUser(userDto: UserCreateReplaceDto): Long

	fun getUser(id: Long): UserDto

	fun getUsers(filters: UserFiltersDto, pageable: Pageable): UsersDto

//	fun replaceUser(id: Long, userDto: UserCreateReplaceDto)

//	fun deleteUser(id: Long)
}