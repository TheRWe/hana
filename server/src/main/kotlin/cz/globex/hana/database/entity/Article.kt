package cz.globex.hana.database.entity

import cz.globex.hana.core.dao.*
import javax.persistence.*

@Entity
data class Article(
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
			Article(title = title, text = text)
		}
	}

	@Suppress("ProtectedInFinal")
	protected constructor() : this("", "")
}