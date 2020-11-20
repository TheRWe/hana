package cz.globex.hana.database.entity

import cz.globex.hana.common.dto.*
import java.time.*
import javax.persistence.*

@Entity
class StockExchange @Suppress("ProtectedInFinal") protected constructor(
	author: User,
	name: String,
	description: String,
	@Enumerated(EnumType.STRING) var type: StockExchangeType,
	price: Int,
	photoUri: String? = null,
	place: Place? = null,
	tags: Set<Tag> = emptySet()
) : Advertisable(
	author = author,
	name = name,
	description = description,
	price = price,
	photoUri = photoUri,
	place = place,
	tags = tags
) {
	@Column(nullable = false)
	var isActual: Boolean = true
}
