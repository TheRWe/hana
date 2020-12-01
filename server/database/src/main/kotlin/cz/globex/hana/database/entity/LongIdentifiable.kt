package cz.globex.hana.database.entity

import javax.persistence.*

@MappedSuperclass
abstract class LongIdentifiable internal constructor() {
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false, updatable = false) // TODO: constant
	protected open var id: Long = 0
	val id_safe: Long get() = id

	@Column(nullable = false)
	open var deleted: Boolean = false
}