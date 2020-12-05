package cz.globex.hana.database.entity.impl

import cz.globex.hana.database.entity.*
import org.hibernate.annotations.*
import java.time.*
import javax.persistence.*
import javax.persistence.Entity

@Entity
class Event(
	author: User,
	name: String,
	description: String,
	dateStartUtc: LocalDateTime,
	dateEndInclusiveUtc: LocalDateTime,
	price: Int,
	photoUri: String? = null,
	place: Place? = null,
	tags: Set<Tag> = emptySet(),
) : Advertisable(
	author = author,
	name = name,
	description = description,
	price = price,
	photoUri = photoUri,
	place = place,
	tags = tags,
) {
	@Column(nullable = false)
	var dateStartUtc: LocalDateTime = dateStartUtc.also { validateDate(it) }
		set(value) {
			validateDate(value)
			field = value
		}

	@Column(nullable = false)
	var dateEndInclusiveUtc: LocalDateTime = dateEndInclusiveUtc.also { validateDate(it) }
		set(value) {
			validateDate(value)
			field = value
		}

	@Basic(fetch = FetchType.LAZY)
	@Formula("(SELECT AVG(CAST(er.score AS FLOAT)) FROM EventRating er WHERE er.advertisable_id = id)")
	var ratingScore: Float? = null
		private set

	@Basic(fetch = FetchType.LAZY)
	@Formula("(SELECT COUNT(er.id) FROM EventRating er WHERE er.advertisable_id = id)")
	var ratingVotes: Int = 0
		private set

	private companion object {
		fun validateDate(value: LocalDateTime) {} // TODO
	}
}
