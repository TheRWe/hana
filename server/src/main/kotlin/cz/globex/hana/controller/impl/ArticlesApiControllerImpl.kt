package cz.globex.hana.controller.impl

import cz.globex.hana.controller.*
import cz.globex.hana.controller.dto.*
import cz.globex.hana.controller.util.*
import cz.globex.hana.core.dao.impl.*
import cz.globex.hana.core.dto.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.*

@RestController
@RequestMapping(path = [ArticlesApiController.PATH])
class ArticlesApiControllerImpl(private val articlesDao: ArticlesDaoImpl) : ArticlesApiController {
	@GetMapping
	override fun retrieveArticles(reqParams: ArticlesRequestDto): ResponseEntity<ArticlesDto> {
		val pageStart = reqParams.pageStart
		val pageSize = reqParams.pageSize
		if ((pageStart == null) != (pageSize == null)) return ResponseEntity.badRequest().build()

		val articles = articlesDao.getArticles(pageStart = pageStart, pageSize = pageSize)
		return ResponseEntity.ok().body(ArticlesDto(articles))
	}

	@PostMapping
	override fun createArticle(@RequestBody article: ArticleDto): ResponseEntity<ResourceInfoDto> {
		val articleId = articlesDao.createArticle(article)
		val location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{${PathVariables.ID}}")
			.buildAndExpand(articleId)
			.toUri()
		return ResponseEntity.created(location).body(ResourceInfoDto(articleId, location))
	}

	@GetMapping(path = ["/{${PathVariables.ID}}"])
	override fun retrieveArticle(
		@PathVariable(PathVariables.ID) id: Int
	): ResponseEntity<ArticleDto> {
		val article = articlesDao.getArticleOrNull(id)
		return if (article != null) {
			ResponseEntity.ok().body(article)
		} else {
			ResponseEntity.notFound().build()
		}
	}
}