package cz.globex.hana.core.dao.impl

import cz.globex.hana.core.dao.*
import cz.globex.hana.database.entity.*
import cz.globex.hana.database.repository.*
import org.springframework.context.annotation.*
import org.springframework.web.servlet.support.*
import java.net.*

@Configuration
class ArticlesDaoImpl(private val articlesRepository: ArticlesRepository) : ArticlesDao {
	override fun getArticles(): List<ArticleDto> {
		return articlesRepository.findAll().map(Article::toDto)
	}

	override fun createArticle(articleDto: ArticleDto): Pair<URI, ArticleDto> {
		val article = articlesRepository.save(Article.from(articleDto))
		val location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(article.id)
			.toUri()
		return location to article.toDto()
	}

	override fun getArticleOrNull(id: Int): ArticleDto? = articlesRepository.getById(id)?.toDto()
}