package cz.globex.hana.core.dao

import cz.globex.hana.core.dao.action.*
import cz.globex.hana.core.dto.*

interface ArticlesDao :
	RetrieveMultipleDaoAction<ArticleFiltersDto, ArticlesDto>,
	CreateDaoAction<ArticleCreateUpdateDto>,
	RetrieveDaoAction<ArticleDto>