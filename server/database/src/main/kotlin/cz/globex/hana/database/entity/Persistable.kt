package cz.globex.hana.database.entity

import javax.persistence.*

@MappedSuperclass
abstract class Persistable {
	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false, updatable = false)
	open val id: Long = 0
}