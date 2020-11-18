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

    companion object {
        fun newInstance(name: String): Tag {
            val trimmedName = name.trim()

            if (trimmedName.isEmpty()) throw IllegalArgumentException()
			
            return Tag(trimmedName)
        }
    }

    protected constructor() : this("")
}
