package cz.globex.hana.database.entity.impl

import cz.globex.hana.database.entity.*
import javax.persistence.*

@Entity
@Table(
	uniqueConstraints = [
		UniqueConstraint(columnNames = [Place.LATITUDE_COLUMN, Place.LONGITUDE_COLUMN])
	]
)
data class Place(
	@Column(nullable = false, updatable = false) val street: String,
	@Column(nullable = false, updatable = false) val houseNumber: String,
	@Column(nullable = false, updatable = false) val city: String,
	@Column(nullable = false, updatable = false) val latitude: Double,
	@Column(nullable = false, updatable = false) val longitude: Double,
) : LongIdentifiable() {
	@OneToMany
	val advertisables: Set<Advertisable> = emptySet()

	internal companion object {
		const val LATITUDE_COLUMN: String = "latitude"
		const val LONGITUDE_COLUMN: String = "longitude"
	}
}
