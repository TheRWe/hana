package cz.globex.hana.controller.impl

import cz.globex.hana.controller.*
import cz.globex.hana.core.dao.impl.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/articles", produces = [MediaType.APPLICATION_JSON_VALUE])
class ArticlesApiControllerImpl(private val articlesDao: ArticlesDaoImpl) : ArticlesApiController {
	@GetMapping
	override fun retrieveArticles(): ResponseEntity<RetrieveArticlesResponse> {
		return ResponseEntity.ok().body(RetrieveArticlesResponse(articlesDao.getArticles()))
	}

	@PostMapping
	override fun createArticle(
		@RequestBody req: CreateArticleRequest
	): ResponseEntity<CreateArticleResponse> {
		val (location, createdArticle) = articlesDao.createArticle(req.article)
		return ResponseEntity.created(location).body(CreateArticleResponse(createdArticle))
	}

	@GetMapping("/{id}")
	override fun retrieveArticle(
		@PathVariable(name = "id") id: Int,
	): ResponseEntity<RetrieveArticleResponse> {
		val article = articlesDao.getArticleOrNull(id)
		return if (article != null) {
			ResponseEntity.ok().body(RetrieveArticleResponse(article))
		} else {
			ResponseEntity.notFound().build()
		}
	}
}