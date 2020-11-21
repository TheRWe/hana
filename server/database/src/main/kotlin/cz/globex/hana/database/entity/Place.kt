package cz.globex.hana.database.entity

import javax.persistence.*

@Entity
@Table(
	uniqueConstraints = [
		UniqueConstraint(columnNames = [Place.LATITUDE_COLUMN, Place.LONGITUDE_COLUMN])
	]
)
data class Place internal constructor(
	@Column(nullable = false, updatable = false) val street: String,
	@Column(nullable = false, updatable = false) val houseNumber: String,
	@Column(nullable = false, updatable = false) val zipCode: String,
	@Column(nullable = false, updatable = false) val latitude: Double,
	@Column(nullable = false, updatable = false) val longitude: Double,
) : Persistable() {
	@OneToMany
	val advertisables: Set<Advertisable> = emptySet()

	companion object {
		const val LATITUDE_COLUMN: String = "latitude"
		const val LONGITUDE_COLUMN: String = "longitude"
	}
}
