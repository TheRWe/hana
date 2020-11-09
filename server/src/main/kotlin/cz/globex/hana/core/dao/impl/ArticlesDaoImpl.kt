package cz.globex.hana.core.dao.impl

import cz.globex.hana.router.dto.*
import cz.globex.hana.core.dao.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.core.util.*
import cz.globex.hana.database.entity.*
import cz.globex.hana.database.repository.*
import org.springframework.context.annotation.*
import kotlin.streams.*

@Configuration
class ArticlesDaoImpl(private val articlesRepository: ArticlesRepository) : ArticlesDao {
	override fun getArticles(pageStart: Int?, pageSize: Int?): List<ArticleDto> {
		val pageable = PageableHandler.getPageable(pageStart = pageStart, pageSize = pageSize)
		return articlesRepository.findAll(pageable).get().map(Article::toDto).toList()
	}

	override fun createArticle(articleDto: ArticleCreateUpdateDto): Int {
		return articlesRepository.save(Article.from(articleDto)).id
	}

	override fun getArticleOrNull(id: Int): ArticleDto? = articlesRepository.getById(id)?.toDto()
}