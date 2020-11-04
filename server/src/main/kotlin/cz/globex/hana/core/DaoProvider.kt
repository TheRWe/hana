package cz.globex.hana.core

import cz.globex.hana.core.dao.impl.*
import org.springframework.context.annotation.*
import org.springframework.stereotype.*

@Component
class DaoProvider(
	@Lazy val articlesDao: ArticlesDaoImpl,
)