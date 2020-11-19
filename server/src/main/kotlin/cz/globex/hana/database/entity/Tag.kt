package cz.globex.hana.database.entity

import java.net.*
import java.time.*
import javax.persistence.*

@Suppress("ProtectedInFinal")
@Entity
data class Tag protected constructor(
    @Column(nullable = false)
    var name: String
) {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    val id: Int = 0

    // Ad
    @ManyToMany
    var ads: Set<Ad> = emptySet()

    // Event
    @ManyToMany
    var events: Set<Event> = emptySet()

    // StockExchange
    @ManyToMany
    var stockExchanges: Set<StockExchange> = emptySet()

    companion object {
        fun newInstance(name: String): Tag {
            val trimmedName = name.trim()

            if (trimmedName.isEmpty()) throw IllegalArgumentException()

            return Tag(trimmedName)
        }
    }

    protected constructor() : this("")
}
