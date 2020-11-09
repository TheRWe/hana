package cz.globex.hana.router.controller.impl

import cz.globex.hana.core.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.*

@RestController
@RequestMapping(path = [ArticlesApiController.PATH])
class ArticlesApiControllerImpl(daoProvider: DaoProvider) : ArticlesApiController {
	private val articlesDao = daoProvider.articlesDao

	override fun retrieveMultiple(filters: ArticleFiltersDto): ResponseEntity<ArticlesDto> {
		val pageStart = filters.pageStart
		val pageSize = filters.pageSize
		if ((pageStart == null) != (pageSize == null)) return ResponseEntity.badRequest().build()

		val articles = articlesDao.getArticles(pageStart = pageStart, pageSize = pageSize)
		return ResponseEntity.ok().body(ArticlesDto(articles))
	}

	override fun create(entity: ArticleCreateUpdateDto): ResponseEntity<ResourceInfoDto> {
		val articleId = articlesDao.createArticle(entity)
		val location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{${PathVariables.ID}}")
			.buildAndExpand(articleId)
			.toUri()
		return ResponseEntity.created(location).body(ResourceInfoDto(articleId, location))
	}

	override fun retrieve(id: Int): ResponseEntity<ArticleDto> {
		val article = articlesDao.getArticleOrNull(id)
		return if (article != null) {
			ResponseEntity.ok().body(article)
		} else {
			ResponseEntity.notFound().build()
		}
	}
}