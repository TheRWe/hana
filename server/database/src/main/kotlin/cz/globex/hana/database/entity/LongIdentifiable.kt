package cz.globex.hana.database.entity

import javax.persistence.*

@MappedSuperclass
abstract class LongIdentifiable internal constructor() {
	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false, updatable = false)
	protected open var id: Long = 0
	val id_safe: Long get() = id
}