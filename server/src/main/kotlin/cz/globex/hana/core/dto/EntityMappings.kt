package cz.globex.hana.core.dto

import cz.globex.hana.database.entity.*

fun Article.Companion.from(articleDto: ArticleDto): Article = with(articleDto) {
	val trimmedTitle = title.trim()
	val trimmedText = text.trim()
	if (trimmedTitle.isEmpty() || trimmedText.isEmpty()) throw IllegalArgumentException()

	Article(title = trimmedTitle, text = trimmedText)
}