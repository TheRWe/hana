package cz.globex.hana.database.repository

import cz.globex.hana.database.entity.*
import org.springframework.data.repository.*

interface ArticlesRepository : PagingAndSortingRepository<Article, Int> {
	fun getById(id: Int): Article?
}