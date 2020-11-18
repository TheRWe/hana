package cz.globex.hana.database.entity

import java.net.*
import java.time.*
import javax.persistence.*

@Suppress("ProtectedInFinal")
@Entity
data class Place protected constructor(
    @Column(nullable = false)
    var address: String,

    @Column(nullable = false)
    var zipCode: String,

    @Column(nullable = false)
    var houseNumber: String,

    @Column(nullable = false)
    var latitude: Double,

    @Column(nullable = false)
    var longitude: Double
) {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    val id: Int = 0

    companion object {
        fun newInstance(
            address: String,
            zipCode: String,
            houseNumber: String,
            latitude: Double,
            longitude: Double
        ): Place {
            // osetreni
            return Place(address, zipCode, houseNumber, latitude, longitude)
        }
    }

    protected constructor() : this("", "", "", 0.0, 0.0)
}
