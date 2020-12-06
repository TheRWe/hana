package cz.globex.hana.database.repository.impl

import cz.globex.hana.database.entity.impl.*
import org.hibernate.annotations.QueryHints.*
import org.hibernate.jpa.QueryHints.*
import org.springframework.data.domain.*
import org.springframework.data.jpa.repository.*
import org.springframework.data.jpa.repository.Query
import java.util.stream.*
import javax.persistence.*

interface UsersRepository :
	JpaRepository<User, Long>
//	ArchivablesRepository
{
	@QueryHints(value = [
		QueryHint(name = HINT_CACHEABLE, value = "false"),
		QueryHint(name = READ_ONLY, value = "true")
	])
	@Query("select u from User u")
	fun stream(): Stream<User>

//	override fun findAllByIsDeletedFalse(pageable: Pageable): Page<User>

//	override fun getByIdAndIsDeletedFalse(id: Long): User

//	@Modifying
//	@Query("UPDATE User u SET u.isDeleted = true WHERE u.id = :id")
//	override fun deleteById(id: Long)
}