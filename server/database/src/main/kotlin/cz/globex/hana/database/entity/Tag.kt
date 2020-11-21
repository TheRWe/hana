package cz.globex.hana.database.entity

import javax.persistence.*

@Entity
data class Tag internal constructor(
	@Column(nullable = false, unique = true) var name: String,
) : Persistable() {
	@ManyToMany
	val taggedAdvertisables: Set<Advertisable> = emptySet()
}
