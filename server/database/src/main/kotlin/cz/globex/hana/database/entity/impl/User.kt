package cz.globex.hana.database.entity.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.database.util.*
import org.hibernate.annotations.*
import java.time.*
import javax.persistence.*
import javax.persistence.Entity

@Entity
class User(
	id: Long,
	firstName: String,
	lastName: String,
	email: String,
	@Enumerated var type: UserType,
	photoUri: String? = null,
)
//	: Archivable()
{
	@Id
	@Column(unique = true, nullable = false, updatable = false)
	var id: Long = id
		private set

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
	var registeredUtc: LocalDateTime = LocalDateTime.now(Clock.systemUTC())
		private set

	@Basic(fetch = FetchType.LAZY)
	@Formula("(SELECT AVG(CAST(ar.score AS FLOAT)) FROM Ad a, AdRating ar WHERE a.author_id = id AND a.id = ar.advertisable_id)")
	var ratingScoreAsSupplier: Float? = null
		private set

	@Basic(fetch = FetchType.LAZY)
	@Formula("(SELECT COUNT(ar.id) FROM Ad a, AdRating ar WHERE a.author_id = id AND a.id = ar.advertisable_id)")
	var ratingVotesAsSupplier: Int = 0
		private set


	@Basic(fetch = FetchType.LAZY)
	@Formula("(SELECT AVG(CAST(ser.score AS FLOAT)) FROM Ad a, StockExchangeRating ser WHERE a.author_id = id AND a.id = ser.advertisable_id)")
	var ratingScoreAsSeller: Float? = null
		private set

	@Basic(fetch = FetchType.LAZY)
	@Formula("(SELECT COUNT(ser.id) FROM Ad a, StockExchangeRating ser WHERE a.author_id = id AND a.id = ser.advertisable_id)")
	var ratingVotesAsSeller: Int = 0
		private set

	private companion object {
		fun validateFirstName(value: String) {} // TODO
		fun validateLastName(value: String) {} // TODO
		fun validateEmail(value: String) {} // TODO
	}
}
