package cz.globex.hana.database.entity

import javax.persistence.*
import java.net.*
import java.time.*

/*TODO:
    - id
    - kdo hodnotil
    - hodnoceni
    - co hodnotil?
    - majitel hodnocene veci */

@Suppress("ProtectedInFinal")
@Entity
data class Rate protected constructor(
    @Column(nullable = false)
    var value: Double
) {
	@Id
	@GeneratedValue
	@Column(updatable = false)
	val id: Int = 0

	// companion object {
	// 	fun newInstance(title: String, text: String): Rate {
	// 		val trimmedTitle = title.trim()
	// 		val trimmedText = text.trim()
	// 		if (trimmedTitle.isEmpty() || trimmedText.isEmpty()) throw IllegalArgumentException()

	// 		return Rate(title = trimmedTitle, text = trimmedText)
	// 	}
	// }

	// protected constructor() : this("", "")
}