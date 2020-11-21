package cz.globex.hana.core.dao.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.database.entity.*
import cz.globex.hana.database.repository.*
import org.springframework.context.annotation.*
import org.springframework.data.domain.*
import kotlin.streams.*

@Configuration
class ArticlesDaoImpl(private val articlesRepository: ArticlesRepository) : ArticlesDao {
	override fun retrieveMultiple(filters: ArticleFiltersDto, pageable: Pageable): ArticlesDto {
		val articles: List<ArticleDto> = articlesRepository
			.findAll(pageable)
			.get()
			.map(Article::toDto)
			.toList()
		return ArticlesDto(articles)
	}

	override fun createOne(entity: ArticleCreateUpdateDto): Long {
		return articlesRepository.save(Article.from(entity)).id
	}

	override fun retrieveOneOrNull(id: Long): ArticleDto? = articlesRepository.getById(id)?.toDto()
}