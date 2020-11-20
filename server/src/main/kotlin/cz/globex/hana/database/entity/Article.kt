package cz.globex.hana.database.entity

import javax.persistence.*

@Entity
data class Article @Suppress("ProtectedInFinal") protected constructor(
	@Column(nullable = false) var title: String,
	@Column(nullable = false) var text: String,
) : Persistable() {
	companion object {
		fun newInstance(title: String, text: String): Article {
			val trimmedTitle = title.trim()
			val trimmedText = text.trim()
			if (trimmedTitle.isEmpty() || trimmedText.isEmpty()) throw IllegalArgumentException()

			return Article(title = trimmedTitle, text = trimmedText)
		}
	}
}