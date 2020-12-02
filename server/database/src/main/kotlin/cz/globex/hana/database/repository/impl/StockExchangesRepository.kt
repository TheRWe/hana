package cz.globex.hana.database.repository.impl

import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.*
import org.springframework.data.domain.*
import org.springframework.data.jpa.repository.*

interface StockExchangesRepository : JpaRepository<StockExchange, Long>, ArchivablesRepository {
	override fun findAllByIsDeletedFalse(pageable: Pageable): Page<StockExchange>

	override fun getByIdAndIsDeletedFalse(id: Long): StockExchange

	@Modifying
	@Query("UPDATE STOCKEXCHANGE se SET se.isDeleted = true WHERE se.id = :id")
	override fun deleteById(id: Long)
}