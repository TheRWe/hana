package cz.globex.hana.router.controller.impl

import cz.globex.hana.core.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [ArticlesApiController.PATH])
class ArticlesApiControllerImpl(daoProvider: DaoProvider) : ArticlesApiController {
	private val articlesDao = daoProvider.articlesDao

	override fun retrieveMultiple(
		filters: ArticleFiltersDto,
		pagination: PaginationDto
	): ResponseEntity<ArticlesDto> {
		return articlesDao.retrieveMultipleAndWrap(filters, pagination)
	}

	override fun createOne(entity: ArticleCreateUpdateDto): ResponseEntity<ResourceInfoDto> {
		return articlesDao.createOneAndWrap(entity)
	}

	override fun retrieveOne(id: Int): ResponseEntity<ArticleDto> {
		return articlesDao.retrieveOneAndWrap(id)
	}
}