package cz.globex.hana.database.repository.impl

import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.*
import org.hibernate.annotations.QueryHints.*
import org.hibernate.jpa.QueryHints.*
import org.springframework.data.domain.*
import org.springframework.data.jpa.repository.*
import org.springframework.data.jpa.repository.Query
import java.util.stream.*
import javax.persistence.*

interface EventsRepository : JpaRepository<Event, Long>, ArchivablesRepository {
	@QueryHints(value = [
		QueryHint(name = HINT_CACHEABLE, value = "false"),
		QueryHint(name = READ_ONLY, value = "true")
	])
	@Query("select e from Event e")
	fun stream(): Stream<Event>

	override fun findAllByIsDeletedFalse(pageable: Pageable): Page<Event>

	override fun getByIdAndIsDeletedFalse(id: Long): Event

	@Modifying
	@Query("UPDATE Event e SET e.isDeleted = true WHERE e.id = :id AND e.isDeleted = false")
	override fun deleteById(id: Long)
}