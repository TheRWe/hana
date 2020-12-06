package cz.globex.hana.core.dao.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.impl.*
import org.springframework.data.domain.*
import org.springframework.http.*
import org.springframework.stereotype.*
import org.springframework.transaction.annotation.*
import org.springframework.web.server.*
import java.time.*
import java.time.format.*
import java.util.stream.*
import kotlin.streams.*

@Component
internal class UsersDaoImpl protected constructor(
	private val usersRepository: UsersRepository,
) : UsersDao {
//	override fun createUser(userDto: UserCreateReplaceDto): Long {
//		val user = with(userDto) {
//			User(
//				firstName = firstName,
//				lastName = lastName,
//				email = email,
//				type = type,
//				photoUri = photoUri
//			)
//		}
//		return usersRepository.save(user).id_safe
//	}

	@Transactional(readOnly = true)
//	override fun getUser(id: Long): UserDto = usersRepository.getByIdAndIsDeletedFalse(id).toDto()
	override fun getUser(id: Long): UserDto = usersRepository.getOne(id).toDto()

	@Transactional(readOnly = true)
	override fun getUsers(filters: UserFiltersDto, pageable: Pageable): UsersDto {
//		val users: Set<UserDto> = usersRepository
////			.findAllByIsDeletedFalse(pageable)
//			.findAll(pageable)
//			.get()
//			.map(User::toDto)
//			.collect(Collectors.toSet())
//		return UsersDto(users)

		val registeredStartUtc = filters.registeredStartUtc?.let { LocalDateTime.parse(it, DateTimeFormatter.ISO_LOCAL_DATE_TIME) }
		val registeredEndInclusiveUtc = filters.registeredEndInclusiveUtc?.let { LocalDateTime.parse(it, DateTimeFormatter.ISO_LOCAL_DATE_TIME) }
		if (registeredStartUtc != null && registeredEndInclusiveUtc != null && registeredStartUtc.isAfter(registeredEndInclusiveUtc)) {
			throw ResponseStatusException(HttpStatus.BAD_REQUEST)
		}

		var usersStream: Stream<User> = usersRepository.stream()

		// TODO: these operations should be done on the db level
		with(filters) {
			if (type != null) usersStream = usersStream.filter { type == it.type }
			if (registeredStartUtc != null) usersStream = usersStream.filter { it.registeredUtc.isAfter(registeredStartUtc) || it.registeredUtc.isEqual(registeredStartUtc) }
			if (registeredEndInclusiveUtc != null) usersStream = usersStream.filter { it.registeredUtc.isBefore(registeredEndInclusiveUtc) || it.registeredUtc.isEqual(registeredEndInclusiveUtc) }
			if (ratingAsSellerScoreStart != null) usersStream = usersStream.filter { if (it.ratingScoreAsSeller == null) false else ratingAsSellerScoreStart!! <= it.ratingScoreAsSeller!! }
			if (ratingAsSellerScoreEndInclusive != null) usersStream = usersStream.filter { if (it.ratingScoreAsSeller == null) false else ratingAsSellerScoreEndInclusive!! >= it.ratingScoreAsSeller!! }
			if (ratingAsSellerVotesCountStart != null) usersStream = usersStream.filter { ratingAsSellerVotesCountStart!! <= it.ratingVotesAsSeller }
			if (ratingAsSellerVotesCountEndInclusive != null) usersStream = usersStream.filter { ratingAsSellerVotesCountEndInclusive!! >= it.ratingVotesAsSeller }
			if (ratingAsSupplierScoreStart != null) usersStream = usersStream.filter { if (it.ratingScoreAsSupplier == null) false else ratingAsSupplierScoreStart!! <= it.ratingScoreAsSupplier!! }
			if (ratingAsSupplierScoreEndInclusive != null) usersStream = usersStream.filter { if (it.ratingScoreAsSupplier == null) false else ratingAsSupplierScoreEndInclusive!! >= it.ratingScoreAsSupplier!! }
			if (ratingAsSupplierVotesCountStart != null) usersStream = usersStream.filter { ratingAsSupplierVotesCountStart!! <= it.ratingVotesAsSupplier }
			if (ratingAsSupplierVotesCountEndInclusive != null) usersStream = usersStream.filter { ratingAsSupplierVotesCountEndInclusive!! >= it.ratingVotesAsSupplier }
		}
		val users: List<User> = with(pageable) {
			if (isPaged) {
				usersStream
					.limit((pageNumber * pageSize).toLong())
					.toList()
					.drop((pageNumber - 1) * pageSize)
			} else {
				usersStream.toList()
			}
		}
		return UsersDto(users.mapTo(mutableSetOf(), User::toDto))
	}

//	override fun replaceUser(id: Long, userDto: UserCreateReplaceDto) {
//		val user = usersRepository.getByIdAndIsDeletedFalse(id)
//		user.apply {
//			firstName = userDto.firstName
//			lastName = userDto.lastName
//			email = userDto.email
//			type = userDto.type
//			photoUri = userDto.photoUri
//		}
//		usersRepository.save(user)
//	}

//	@Transactional
//	override fun deleteUser(id: Long){
//		if (!usersRepository.existsByIdAndIsDeletedFalse(id)) throw EntityNotFoundException()
//		usersRepository.deleteById(id)
//	}
}