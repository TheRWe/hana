package cz.globex.hana.database.entity

import java.time.*
import javax.persistence.*

@Entity
class Event internal constructor(
	author: User,
	name: String,
	description: String,
	@Column(nullable = false) var dateStartUtc: LocalDateTime,
	@Column(nullable = false) var dateEndInclusiveUtc: LocalDateTime,
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
	@Transient
	var ratingScore: Double = 0.0

	@Transient
	var ratingVotesCount: Int = 0
}
