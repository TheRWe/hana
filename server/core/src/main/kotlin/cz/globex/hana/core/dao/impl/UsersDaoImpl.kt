package cz.globex.hana.core.dao.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.impl.*
import org.springframework.data.domain.*
import org.springframework.stereotype.*
import org.springframework.transaction.annotation.*
import java.util.stream.*
import javax.persistence.*

@Component
internal class UsersDaoImpl protected constructor(
	private val usersRepository: UsersRepository,
) : UsersDao {
	override fun createUser(userDto: UserCreateReplaceDto): Long {
		val user = with(userDto) {
			User(
				firstName = firstName,
				lastName = lastName,
				email = email,
				type = type,
				photoUri = photoUri
			)
		}
		return usersRepository.save(user).id_safe
	}

	@Transactional(readOnly = true)
	override fun getUser(id: Long): UserDto = usersRepository.getByIdAndIsDeletedFalse(id).toDto()

	@Transactional(readOnly = true)
	override fun getUsers(filters: UserFiltersDto, pageable: Pageable): UsersDto {
		val users: Set<UserDto> = usersRepository
			.findAllByIsDeletedFalse(pageable)
			.get()
			.map(User::toDto)
			.collect(Collectors.toSet())
		return UsersDto(users)
	}

	override fun replaceUser(id: Long, userDto: UserCreateReplaceDto) {
		val user = usersRepository.getByIdAndIsDeletedFalse(id)
		user.apply {
			firstName = userDto.firstName
			lastName = userDto.lastName
			email = userDto.email
			type = userDto.type
			photoUri = userDto.photoUri
		}
		usersRepository.save(user)
	}

	@Transactional
	override fun deleteUser(id: Long){
		if (!usersRepository.existsByIdAndIsDeletedFalse(id)) throw EntityNotFoundException()
		usersRepository.deleteById(id)
	}
}