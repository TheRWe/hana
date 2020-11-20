package cz.globex.hana.database.entity

import cz.globex.hana.common.dto.*
import javax.persistence.*

@Entity
class Ad @Suppress("ProtectedInFinal") protected constructor(
	author: User,
	name: String,
	description: String,
	price: Int,
	@Enumerated(EnumType.STRING) var type: AdType,
	photoUri: String? = null,
	place: Place? = null,
	tags: Set<Tag> = emptySet(),
) : Advertisable(
	author = author,
	name = name,
	description = description,
	price = price,
	tags = tags,
	photoUri = photoUri,
	place = place
) {
	@Column(nullable = false)
	var isActual: Boolean = true
}
