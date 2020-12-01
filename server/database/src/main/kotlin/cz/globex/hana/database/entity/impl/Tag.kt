package cz.globex.hana.database.entity.impl

import cz.globex.hana.database.entity.*
import javax.persistence.*

@Entity
class Tag(
	id: String,
) {
	@Id
	@Column(name = NAME_COLUMN, nullable = false, unique = true)
	var id: String = id.also { validateName(it) }
		set(value) {
			validateName(value)
			field = value
		}

	var name: String
		get() = id
		set(value) {
			id = value
		}

	@ManyToMany
	@JoinColumn(name = ADVERTISABLES_COLUMN)
	private var taggedAdvertisables: MutableSet<Advertisable> = mutableSetOf() // TODO: backing field

	private companion object {
		const val NAME_COLUMN = "name"
		const val ADVERTISABLES_COLUMN = "advertisables"

		fun validateName(value: String) {}
	}
}
