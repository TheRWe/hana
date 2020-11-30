package cz.globex.hana.database.entity.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.database.entity.*
import cz.globex.hana.database.util.*
import cz.globex.hana.database.util.validatePhotoUri
import java.time.*
import javax.persistence.*

@Entity
class User(
	firstName: String,
	lastName: String,
	email: String,
	@Enumerated(EnumType.STRING) var type: UserType,
	photoUri: String? = null,
) : LongIdentifiable() {
	@Column(nullable = false)
	var firstName: String = firstName.also { validateFirstName(it) }
		set(value) {
			validateFirstName(value)
			field = value
		}

	@Column(nullable = false)
	var lastName: String = lastName.also { validateLastName(it) }
		set(value) {
			validateLastName(value)
			field = value
		}

	@Column(nullable = false)
	var email: String = email.also { validateEmail(it) }
		set(value) {
			validateEmail(value)
			field = value
		}

	@Column
	var photoUri: String? = photoUri?.also { validatePhotoUri(it) }
		set(value) {
			if (value != null) validatePhotoUri(value)
			field = value
		}

	@Column(nullable = false)
	val registeredUtc: LocalDateTime = LocalDateTime.now(Clock.systemUTC())

	@Transient
	var ratingAsSupplier: Double = 0.0

	@Transient
	var ratingAsSeller: Double = 0.0

	private companion object {
		fun validateFirstName(value: String) {} // TODO
		fun validateLastName(value: String) {} // TODO
		fun validateEmail(value: String) {} // TODO
	}
}
