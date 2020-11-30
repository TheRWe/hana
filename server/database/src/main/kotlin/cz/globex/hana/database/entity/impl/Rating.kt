package cz.globex.hana.database.entity.impl

import cz.globex.hana.database.entity.*
import javax.persistence.*

@Entity
@Table(
	uniqueConstraints = [
		UniqueConstraint(columnNames = [Rating.RATER_COLUMN, Rating.ADVERTISABLE_COLUMN])
	]
)
class Rating(
	@ManyToOne(optional = false)
	@JoinColumn(name = RATER_COLUMN)
	val rater: User,

	@ManyToOne(optional = false)
	@JoinColumn(name = ADVERTISABLE_COLUMN)
	val ratedAdvertisable: Advertisable,

	value: Int,
) : LongIdentifiable() {
	@Column(nullable = false, updatable = false)
	var value: Int = value.also { validateValue(value) }
		set(value) {
			validateValue(value)
			field = value
		}

	internal companion object {
		const val RATER_COLUMN: String = "rater"
		const val ADVERTISABLE_COLUMN: String = "advertisable"

		private fun validateValue(value: Int) {} // TODO
	}
}