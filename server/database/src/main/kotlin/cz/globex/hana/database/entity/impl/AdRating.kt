package cz.globex.hana.database.entity.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.database.entity.*
import javax.persistence.*

@Entity(name = "ADRATING")
@Table(
	uniqueConstraints = [
		UniqueConstraint(columnNames = [Rating.AUTHOR_COLUMN, Rating.ADVERTISABLE_COLUMN])
	]
)
class AdRating(
	author: User,

	@ManyToOne(optional = false)
	@JoinColumn(name = ADVERTISABLE_COLUMN)
	override var advertisable: Advertisable,
	score: RatingScore,
) : Rating(author, advertisable, score)