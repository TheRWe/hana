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

interface StockExchangesRepository : JpaRepository<StockExchange, Long>, ArchivablesRepository {
	@QueryHints(value = [
		QueryHint(name = HINT_CACHEABLE, value = "false"),
		QueryHint(name = READ_ONLY, value = "true")
	])
	@Query("select se from STOCKEXCHANGE se")
	fun stream(): Stream<StockExchange>

	override fun findAllByIsDeletedFalse(pageable: Pageable): Page<StockExchange>

	override fun getByIdAndIsDeletedFalse(id: Long): StockExchange

	@Modifying
	@Query("UPDATE STOCKEXCHANGE se SET se.isDeleted = true WHERE se.id = :id")
	override fun deleteById(id: Long)
}