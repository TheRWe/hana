package cz.globex.hana.database.entity

import javax.persistence.*

@Entity
@Table(
	uniqueConstraints = [
		UniqueConstraint(columnNames = [Rating.RATER_COLUMN, Rating.ADVERTISABLE_COLUMN])
	]
)
data class Rating internal constructor(
	@ManyToOne(optional = false)
	@JoinColumn(name = RATER_COLUMN)
	val rater: User,

	@ManyToOne(optional = false)
	@JoinColumn(name = ADVERTISABLE_COLUMN)
	val ratedAdvertisable: Advertisable,

	@Column(nullable = false, updatable = false) val value: Int,
) : Persistable() {
	companion object {
		const val RATER_COLUMN: String = "rater"
		const val ADVERTISABLE_COLUMN: String = "advertisable"
	}
}