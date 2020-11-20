package cz.globex.hana.database.entity

import javax.persistence.*

@Entity
data class Tag @Suppress("ProtectedInFinal") protected constructor(
	@Column(nullable = false, unique = true) var name: String,
) : Persistable() {
	@ManyToMany
	val taggedAdvertisables: Set<Advertisable> = emptySet()
}
