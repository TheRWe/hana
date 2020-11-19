package cz.globex.hana.database.entity

import java.net.*
import java.time.*
import javax.persistence.*

@Suppress("ProtectedInFinal")
@Entity
data class Event protected constructor(
    @Column(nullable = false)
    var authorId: Int,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var description: String,

    @ManyToOne()
    var place: Place?,

    @Column(nullable = true)
    var photoUri: String?,

    @ManyToMany
    var tags: Set<Tag>?,

    @Column(nullable = false)
    var dateStart: LocalDateTime,

    @Column(nullable = false)
    var dateEndInclusive: LocalDateTime,

    @Column(nullable = false)
    var entryFee: Int
) {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    val id: Int = 0

    @Transient
    var ratingScore: Double = 0.0

    @Transient
    var ratingVotesCount: Int = 0

    @Column(nullable = false)
    var created: LocalDateTime = LocalDateTime.now()

    companion object {
        fun newInstance(
            authorId: Int,
            name: String,
            description: String,
            place: Place?,
            photoUri: String?,
            tags: Set<Tag>?,
            dateStart: LocalDateTime,
            dateEndInclusive: LocalDateTime,
            entryFee: Int
        ): Event {
            val trimmedName = name.trim()
	        val trimmedDescription = description.trim()

            if (trimmedName.isEmpty()) throw IllegalArgumentException()
            
            return Event(authorId, trimmedName, trimmedDescription, place, photoUri, tags, dateStart, dateEndInclusive, entryFee)
        }
    }

    protected constructor() : this(0, "", "", null, null, null, 
        LocalDateTime.now(), LocalDateTime.now(), 0)
}
