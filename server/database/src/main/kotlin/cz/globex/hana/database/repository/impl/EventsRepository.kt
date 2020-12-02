package cz.globex.hana.database.repository.impl

import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.*
import org.springframework.data.domain.*
import org.springframework.data.jpa.repository.*

interface EventsRepository : JpaRepository<Event, Long>, ArchivablesRepository {
	override fun findAllByIsDeletedFalse(pageable: Pageable): Page<Event>

	override fun getByIdAndIsDeletedFalse(id: Long): Event

	@Modifying
	@Query("UPDATE Event e SET e.isDeleted = true WHERE e.id = :id AND e.isDeleted = false")
	override fun deleteById(id: Long)
}