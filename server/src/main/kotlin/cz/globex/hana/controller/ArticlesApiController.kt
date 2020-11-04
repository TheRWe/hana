package cz.globex.hana.controller

import cz.globex.hana.controller.util.*
import cz.globex.hana.core.dao.*
import org.springframework.http.*

interface ArticlesApiController {
	fun retrieveArticles(): ResponseEntity<RetrieveArticlesResponse>

	fun createArticle(req: CreateArticleRequest): ResponseEntity<CreateArticleResponse>

	fun retrieveArticle(id: Int): ResponseEntity<RetrieveArticleResponse>
}

@CommonInterface
data class RetrieveArticlesResponse(
	val articles: List<ArticleDto>
)

@CommonInterface
data class CreateArticleRequest(
	val article: ArticleDto
)

@CommonInterface
data class CreateArticleResponse(
	val article: ArticleDto
)

@CommonInterface
data class RetrieveArticleResponse(
	val article: ArticleDto
)