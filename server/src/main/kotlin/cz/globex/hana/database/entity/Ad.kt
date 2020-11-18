package cz.globex.hana.database.entity

import cz.globex.hana.core.dto.AdType

import java.net.*
import java.time.*
import javax.persistence.*

@Suppress("ProtectedInFinal")
@Entity
data class Ad protected constructor(
    @Column(nullable = false)
    var authorId: Int,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var description: String,

    @ManyToOne(nullable = true)
    var place: Place? = null,

    @Column(nullable = true)
    var photoUri: String?,

    // ?
    @OneToMany(mappedBy = "ad")
    val tags: LinkedHashSet<TagAd>,

    @Column(nullable = true)
    var isActual: Boolean,

    @Column(nullable = true)
    var payout: Int,

    @Enumerated(EnumType.STRING)
    var type: AdType,
) {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    val id: Int = 0

    @Column(nullable = false)
    var created: String = ""

    // companion object {
    //     fun newInstance(
    //         firstName: String,
    //         lastName: String,
    //         email: String,
    //         type: UserType,
    //         photoUri: String?
    //     ): Ad {
    //         val trimmedFirstName = firstName.trim()
    //         val trimmedLastName = lastName.trim()
    //         val trimmedEmail = email.trim()

    //         val somethingIsEmpty = trimmedFirstName.isEmpty() || trimmedLastName.isEmpty() || trimmedEmail.isEmpty()
    //         if (!email.contains("@") || somethingIsEmpty) throw IllegalArgumentException()
			
    //         return Ad(firstName, lastName, email, type, photoUri)
    //     }
    // }

    // protected constructor() : this("", "", "", UserType.PERSON, null)
}
