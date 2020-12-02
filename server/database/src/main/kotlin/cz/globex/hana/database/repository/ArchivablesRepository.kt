package cz.globex.hana.database.repository

import cz.globex.hana.database.entity.*
import org.springframework.data.domain.*

interface ArchivablesRepository {
	fun findAllByIsDeletedFalse(pageable: Pageable): Page<out Archivable>

	fun getByIdAndIsDeletedFalse(id: Long): Archivable
}