package cz.globex.hana.database.entity.impl

import cz.globex.hana.database.entity.*
import java.time.*
import javax.persistence.*

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

	@Transient
	var ratingScore: Double = 0.0

	@Transient
	var ratingVotesCount: Int = 0

	private companion object {
		fun validateDate(value: LocalDateTime) {} // TODO
	}
}
