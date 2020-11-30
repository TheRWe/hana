package cz.globex.hana.database.entity

import javax.persistence.*

@MappedSuperclass
abstract class LongIdentifiable internal constructor() : Persistable() {
	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false, updatable = false)
	open val id: Long = 0

	@Column(nullable = false)
	open var deleted: Boolean = false
}