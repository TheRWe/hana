package cz.globex.hana.database.entity

import cz.globex.hana.core.dto.StockExchangeType

import java.net.*
import java.time.*
import javax.persistence.*

@Suppress("ProtectedInFinal")
@Entity
data class StockExchange protected constructor(
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
	var isActual: Boolean,
	
	@Enumerated(EnumType.STRING)
	var type: StockExchangeType,
	
	@Column(nullable = false)
	var cost: Int,   
) {
	@Id
	@GeneratedValue
	@Column(updatable = false)
	val id: Int = 0

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
			isActual: Boolean,			
			type: StockExchangeType,			
			cost: Int,			
	    ): StockExchange {
	        val trimmedName = name.trim()
	        val trimmedDescription = description.trim()

			if (trimmedName.isEmpty()) throw IllegalArgumentException()

			return StockExchange(authorId, trimmedName, trimmedDescription, place, photoUri, tags,
				isActual, type, cost)
	    }
	}

	protected constructor() : this(0, "", "", null, null, null, false, StockExchangeType.BUY, 0)
}
