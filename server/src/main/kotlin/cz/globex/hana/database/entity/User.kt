package cz.globex.hana.database.entity

import cz.globex.hana.common.dto.*
import java.time.*
import javax.persistence.*

@Entity
data class User @Suppress("ProtectedInFinal") protected constructor(
	@Column(nullable = false) var firstName: String,
	@Column(nullable = false) var lastName: String,
	@Column(nullable = false) var email: String,
	@Enumerated(EnumType.STRING) var type: UserType,
	@Column var photoUri: String? = null,
) : Persistable() {
	@Column(nullable = false)
	val registeredUtc: LocalDateTime = LocalDateTime.now(Clock.systemUTC())

	@Transient
	var ratingAsSupplier: Double = 0.0

	@Transient
	var ratingAsSeller: Double = 0.0
}
