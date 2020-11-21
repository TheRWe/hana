package cz.globex.hana.database.entity

import java.time.*
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Advertisable protected constructor(
	@ManyToOne(optional = false) open val author: User,
	@Column(nullable = false) open var name: String,
	@Column(nullable = false) open var description: String,
	@ManyToMany open var tags: Set<Tag>,
	@Column(nullable = false) open var price: Int,
	@Column open var photoUri: String?,
	@ManyToOne open var place: Place?,
) : Persistable() {
	@Column(nullable = false, updatable = false)
	open val createdUtc: LocalDateTime = LocalDateTime.now(Clock.systemUTC())

	@OneToMany
	open val ratings: MutableSet<Rating> = mutableSetOf()
}