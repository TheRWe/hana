package cz.globex.hana.database.entity.impl

import cz.globex.hana.database.entity.*
import javax.persistence.*

@Entity
data class Tag(
	@Id
	@Column(name = "name", nullable = false, unique = true)
	var id: String,
) : Persistable() {
	var name: String
		get() = id
		set(value) {
			id = value
		}

	@ManyToMany
	val taggedAdvertisables: Set<Advertisable> = emptySet()

	companion object {
		fun newInstance(name: String): Tag {
			// TODO: checks
			return Tag(name)
		}
	}
}
