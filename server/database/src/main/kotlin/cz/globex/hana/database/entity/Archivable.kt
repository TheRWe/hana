package cz.globex.hana.database.entity

import javax.persistence.*

@MappedSuperclass
abstract class Archivable protected constructor() : LongIdentifiable() {
	@Column(nullable = false)
	protected open var isDeleted: Boolean = false
}