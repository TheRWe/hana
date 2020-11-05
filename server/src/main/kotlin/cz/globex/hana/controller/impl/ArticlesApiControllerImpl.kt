package cz.globex.hana.controller.impl

import cz.globex.hana.controller.*
import cz.globex.hana.controller.util.RequestParam
import cz.globex.hana.core.dao.impl.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.*

@RestController
@RequestMapping(ArticlesApiController.PATH, produces = [MediaType.APPLICATION_JSON_VALUE])
class ArticlesApiControllerImpl(private val articlesDao: ArticlesDaoImpl) : ArticlesApiController {
	@GetMapping
	override fun retrieveArticles(
		req: ArticlesRetrieveRequestDto
	): ResponseEntity<ArticlesRetrieveResponseDto> {
		val pageNumber = req.pageNumber
		val pageSize = req.pageSize
		if ((pageNumber == null) != (pageSize == null)) return ResponseEntity.badRequest().build()

		val articles = articlesDao.getArticles(pageNumber = pageNumber, pageSize = pageSize)
		return ResponseEntity.ok().body(ArticlesRetrieveResponseDto(articles))
	}

	@PostMapping
	override fun createArticle(
		@RequestBody req: ArticleCreateRequestDto
	): ResponseEntity<CreateResponseDto> {
		val articleId = articlesDao.createArticle(req.article)
		val location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{${RequestParam.ID}}")
			.buildAndExpand(articleId)
			.toUri()
		val resourceInfo = ResourceInfoDto(articleId, location)
		return ResponseEntity.created(location).body(CreateResponseDto(resourceInfo))
	}

	@GetMapping("/{${RequestParam.ID}}")
	override fun retrieveArticle(
		@PathVariable(RequestParam.ID) id: Int,
	): ResponseEntity<ArticleRetrieveResponseDto> {
		val article = articlesDao.getArticleOrNull(id)
		return if (article != null) {
			ResponseEntity.ok().body(ArticleRetrieveResponseDto(article))
		} else {
			ResponseEntity.notFound().build()
		}
	}
}