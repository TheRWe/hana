package cz.globex.hana.database.repository

import cz.globex.hana.database.entity.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticlesRepository : JpaRepository<Article, Int> {
	fun getById(id: Int): Article?
}