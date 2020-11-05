package cz.globex.hana.database.entity

import cz.globex.hana.core.dao.*
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
		fun from(articleDto: ArticleDto): Article = with(articleDto) {
			val trimmedTitle = title.trim()
			val trimmedText = text.trim()
			if (trimmedTitle.isEmpty() || trimmedText.isEmpty()) throw IllegalArgumentException()

			Article(title = trimmedTitle, text = trimmedText)
		}
	}

	protected constructor() : this("", "")
}