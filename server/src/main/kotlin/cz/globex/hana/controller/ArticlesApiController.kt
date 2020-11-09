package cz.globex.hana.controller

import cz.globex.hana.controller.dto.*
import cz.globex.hana.core.dto.*
import org.springframework.http.*

interface ArticlesApiController {
	companion object {
		const val PATH: String = ApiController.PATH + "/articles"
	}

	fun retrieveArticles(reqParams: ArticlesRequestDto): ResponseEntity<ArticlesDto>

	fun createArticle(article: ArticleDto): ResponseEntity<ResourceInfoDto>

	fun retrieveArticle(id: Int): ResponseEntity<ArticleDto>
}