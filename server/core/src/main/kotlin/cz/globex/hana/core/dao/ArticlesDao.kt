package cz.globex.hana.core.dao

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.action.*

interface ArticlesDao :
	RetrieveMultipleDaoAction<ArticleFiltersDto, ArticlesDto>,
	CreateDaoAction<ArticleCreateUpdateDto>,
	RetrieveDaoAction<ArticleDto>