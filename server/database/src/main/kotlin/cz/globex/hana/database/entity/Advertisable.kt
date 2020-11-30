package cz.globex.hana.database.entity

import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.util.*
import java.time.*
import javax.persistence.*
import kotlin.reflect.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Advertisable internal constructor(
	@ManyToOne(optional = false) open val author: User,
	name: String,
	description: String,
	tags: Set<Tag>,
	price: Int,
	photoUri: String?,
	@ManyToOne open var place: Place?,
) : LongIdentifiable() {
	@Column(nullable = false)
	open var name: String = name.also { validateName(it) }
		set(value) {
			validateName(value)
			field = value
		}

	@Column(nullable = false)
	open var description: String = description.also { validateDescription(it) }
		set(value) {
			validateDescription(value)
			field = value
		}

	@ManyToMany
	open var tags: Set<Tag> = tags.also { validateTags(it) }
		set(value) {
			validateTags(value)
			field = value
		}

	@Column(nullable = false)
	open var price: Int = price.also { validatePrice(it) }
		set(value) {
			validatePrice(value)
			field = value
		}

	@Column
	open var photoUri: String? = photoUri?.also { validatePhotoUri(it) }
		set(value) {
			if (value != null) validatePhotoUri(value)
			field = value
		}

	@Column(nullable = false, updatable = false)
	open val createdUtc: LocalDateTime = LocalDateTime.now(Clock.systemUTC())

	@OneToMany
	open val ratings: MutableSet<Rating> = mutableSetOf()

	private companion object {
		fun validateName(value: String) {} // TODO
		fun validateDescription(value: String) {} // TODO
		fun validateTags(value: Set<Tag>) {} // TODO
		fun validatePrice(value: Int) {} // TODO
	}
}