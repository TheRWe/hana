package cz.globex.hana.database.entity

import cz.globex.hana.common.dto.*
import cz.globex.hana.database.entity.impl.*
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Rating(
	@ManyToOne(optional = false)
	@JoinColumn(name = AUTHOR_COLUMN)
	protected open var author: User,
	advertisable: Advertisable,
	score: RatingScore,
) : LongIdentifiable() {
	val author_safe: User get() = author

	protected abstract var advertisable: Advertisable
	val advertisable_safe: Advertisable get() = advertisable

	@Column(name = SCORE_COLUMN, nullable = false)
	protected open var score: Short = score.value
	val score_safe: Short get() = score

	fun setScore(value: RatingScore) {
		score = value.value
	}

	internal companion object {
		private const val SCORE_COLUMN: String = "score"
		const val AUTHOR_COLUMN: String = "author_id"
		const val ADVERTISABLE_COLUMN: String = "advertisable_id"
	}
}