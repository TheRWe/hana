package cz.globex.hana.database.entity

import cz.globex.hana.core.dto.UserType

import java.net.*
import java.time.*
import javax.persistence.*

@Suppress("ProtectedInFinal")
@Entity
data class User protected constructor(
    @Column(nullable = false)
    var firstName: String,

    @Column(nullable = false)
    var lastName: String,

    @Column(nullable = false)
    var email: String,

    @Enumerated(EnumType.STRING)
    var type: UserType,

    @Column(nullable = true)
    var photoUri: String?
) {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    val id: Int = 0

    @Column(nullable = false)
    var registered: String = ""

    @Transient
    var ratingAsSupplier: Double = 0.0

    @Transient
    var ratingAsSeller: Double = 0.0

    companion object {
        fun newInstance(
            firstName: String,
            lastName: String,
            email: String,
            type: UserType,
            photoUri: String?
        ): User {
            val trimmedFirstName = firstName.trim()
            val trimmedLastName = lastName.trim()
            val trimmedEmail = email.trim()

            val somethingIsEmpty = trimmedFirstName.isEmpty() || trimmedLastName.isEmpty() || trimmedEmail.isEmpty()
            if (!email.contains("@") || somethingIsEmpty) throw IllegalArgumentException()
			
            return User(firstName, lastName, email, type, photoUri)
        }
    }

    protected constructor() : this("", "", "", UserType.PERSON, null)
}
