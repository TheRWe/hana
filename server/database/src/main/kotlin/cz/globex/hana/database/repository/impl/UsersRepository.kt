package cz.globex.hana.database.repository.impl

import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.*
import org.springframework.data.domain.*
import org.springframework.data.jpa.repository.*

interface UsersRepository : JpaRepository<User, Long>, ArchivablesRepository {
	override fun findAllByIsDeletedFalse(pageable: Pageable): Page<User>

	override fun getByIdAndIsDeletedFalse(id: Long): User
}