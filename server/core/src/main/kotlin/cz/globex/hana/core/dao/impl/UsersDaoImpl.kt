package cz.globex.hana.core.dao.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.*
import org.springframework.context.annotation.*
import org.springframework.data.domain.*
import org.springframework.data.repository.*
import java.util.stream.*

@Configuration
internal class UsersDaoImpl protected constructor(
	private val usersRepository: UsersRepository,
) : UsersDao {
	override fun retrieveMultiple(filters: UserFiltersDto, pageable: Pageable): UsersDto {
		val users: Set<UserDto> = usersRepository
			.findAll(pageable)
			.get()
			.map(User::toDto)
			.collect(Collectors.toSet())
		return UsersDto(users)
	}

	override fun createOne(entity: UserCreateUpdateDto): Long {
		val user = with(entity) {
			User(
				firstName = firstName,
				lastName = lastName,
				email = email,
				type = type,
				photoUri = photoUri
			)
		}
		return usersRepository.save(user).id
	}

	override fun retrieveOne(id: Long): UserDto = usersRepository.getOne(id).toDto()

	override fun updateOne(id: Long, entity: UserCreateUpdateDto) {
		val user = usersRepository.getOne(id)
		user.apply {
			firstName = entity.firstName
			lastName = entity.lastName
			email = entity.email
			type = entity.type
			photoUri = entity.photoUri
		}
		usersRepository.save(user)
	}

	override fun deleteOne(id: Long) {
		val user = usersRepository.getOne(id)
		user.deleted = true
		usersRepository.save(user)
	}

	override fun reportOne(id: Long, report: ReportDto): ResourceInfoDto<Long> {
		TODO("Not yet implemented")
	}

	override fun AdvertisablesDao<*, *, *, *, *>.getUserOrNull(id: Long): User? {
		return usersRepository.findByIdOrNull(id)
	}
}