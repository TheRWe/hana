package cz.globex.hana.database.entity.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.database.entity.*
import javax.persistence.*

@Entity(name = "STOCKEXCHANGERATING")
class StockExchangeRating(
	author: User,

	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = ADVERTISABLE_COLUMN)
	override var advertisable: Advertisable,
	score: RatingScore,
) : Rating(author, advertisable, score)