package cz.globex.hana.router.controller

import cz.globex.hana.common.dto.*
import cz.globex.hana.router.controller.action.*

interface ArticlesApiController :
	RetrieveMultipleAction<ArticleFiltersDto, ArticlesDto>,
	CreateAction<ArticleCreateUpdateDto>,
	RetrieveAction<ArticleDto> {

	companion object {
		const val PATH: String = ApiController.PATH + "/articles"
	}
}