package cz.globex.hana.database.entity.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.database.entity.*
import javax.persistence.*

@Entity
class Ad(
	author: User,
	name: String,
	description: String,
	@Enumerated(EnumType.STRING) var type: AdType,
	price: Int,
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
