package cz.globex.hana.core.dao.impl

import cz.globex.hana.core.dao.*
import cz.globex.hana.database.entity.*
import cz.globex.hana.database.repository.*
import org.springframework.context.annotation.*
import org.springframework.data.domain.*
import kotlin.streams.*

@Configuration
class ArticlesDaoImpl(private val articlesRepository: ArticlesRepository) : ArticlesDao {
	override fun getArticles(pageNumber: Int?, pageSize: Int?): List<ArticleDto> {
		val pageable = if (pageNumber == null || pageSize == null) {
			Pageable.unpaged()
		} else {
			PageRequest.of(pageNumber, pageSize)
		}
		return articlesRepository.findAll(pageable).get().map(Article::toDto).toList()
	}

	override fun createArticle(articleDto: ArticleDto): Int {
		return articlesRepository.save(Article.from(articleDto)).id
	}

	override fun getArticleOrNull(id: Int): ArticleDto? = articlesRepository.getById(id)?.toDto()
}