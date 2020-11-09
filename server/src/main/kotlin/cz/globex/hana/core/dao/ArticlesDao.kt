package cz.globex.hana.core.dao

import cz.globex.hana.core.dto.*

interface ArticlesDao {
	fun getArticles(pageStart: Int? = null, pageSize: Int? = null): List<ArticleDto>

	fun createArticle(articleDto: ArticleDto): Int

	fun getArticleOrNull(id: Int): ArticleDto?
}