package cz.globex.hana.core.dao

import com.fasterxml.jackson.annotation.*
import com.fasterxml.jackson.databind.annotation.*
import cz.globex.hana.controller.deserializer.*
import cz.globex.hana.database.entity.*

interface ArticlesDao {
	fun getArticles(pageNumber: Int? = null, pageSize: Int? = null): List<ArticleDto>

	fun createArticle(articleDto: ArticleDto): Int

	fun getArticleOrNull(id: Int): ArticleDto?
}

fun Article.toDto(): ArticleDto = ArticleDto(title = title, text = text)

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ArticleDto(
	@JsonDeserialize(using = StringDeserializer::class)
	val title: String,

	@JsonDeserialize(using = StringDeserializer::class)
	val text: String,
)