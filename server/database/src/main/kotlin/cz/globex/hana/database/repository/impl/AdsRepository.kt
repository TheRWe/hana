package cz.globex.hana.database.repository.impl

import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.*
import org.springframework.data.domain.*
import org.springframework.data.jpa.repository.*

interface AdsRepository : JpaRepository<Ad, Long>, ArchivablesRepository {
	override fun findAllByIsDeletedFalse(pageable: Pageable): Page<Ad>

	override fun getByIdAndIsDeletedFalse(id: Long): Ad
}