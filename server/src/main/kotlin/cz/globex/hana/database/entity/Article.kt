package cz.globex.hana.database.entity

import javax.persistence.*

@Suppress("ProtectedInFinal")
@Entity
data class Article protected constructor(
	@Column(nullable = false)
	var title: String,

	@Column(nullable = false)
	var text: String,
) {
	@Id
	@GeneratedValue
	@Column(updatable = false)
	val id: Int = 0

	companion object {
		fun newInstance(title: String, text: String): Article {
			val trimmedTitle = title.trim()
			val trimmedText = text.trim()
			if (trimmedTitle.isEmpty() || trimmedText.isEmpty()) throw IllegalArgumentException()

			return Article(title = trimmedTitle, text = trimmedText)
		}
	}

	protected constructor() : this("", "")
}