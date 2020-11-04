package cz.globex.hana.core.dao

import com.fasterxml.jackson.annotation.*
import cz.globex.hana.database.entity.*

interface ArticlesDao {
	fun getArticles(): List<ArticleDto>

	fun createArticle(articleDto: ArticleDto): Int

	fun getArticleOrNull(id: Int): ArticleDto?
}

fun Article.toDto(): ArticleDto = ArticleDto(title = title, text = text)

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ArticleDto(
	val title: String,
	val text: String,
)