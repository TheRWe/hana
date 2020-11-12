package cz.globex.hana.core.dto

import cz.globex.hana.database.entity.*

fun Article.Companion.from(articleDto: ArticleCreateUpdateDto): Article = with(articleDto) {
	newInstance(title = title, text = text)
}