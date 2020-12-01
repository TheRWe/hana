package cz.globex.hana.database.entity.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.database.entity.*
import javax.persistence.*

@Entity(name = "STOCKEXCHANGE")
class StockExchange(
	author: User,
	name: String,
	description: String,
	@Enumerated var type: StockExchangeType,
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
	tags = tags
) {
	@Column(nullable = false)
	var isActual: Boolean = true
}
