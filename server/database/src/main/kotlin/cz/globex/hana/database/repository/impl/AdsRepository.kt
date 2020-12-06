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

interface AdsRepository : JpaRepository<Ad, Long>, ArchivablesRepository {
	@QueryHints(value = [
		QueryHint(name = HINT_CACHEABLE, value = "false"),
		QueryHint(name = READ_ONLY, value = "true")
	])
	@Query("select a from Ad a")
	fun stream(): Stream<Ad>

	override fun findAllByIsDeletedFalse(pageable: Pageable): Page<Ad>

	override fun getByIdAndIsDeletedFalse(id: Long): Ad

	@Modifying
	@Query("UPDATE Ad a SET a.isDeleted = true WHERE a.id = :id")
	override fun deleteById(id: Long)
}