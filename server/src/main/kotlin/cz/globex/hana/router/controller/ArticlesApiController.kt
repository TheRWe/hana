package cz.globex.hana.router.controller

import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.action.*
import cz.globex.hana.router.dto.*

interface ArticlesApiController :
	RetrieveEntitiesAction<ArticlesRequestDto, ArticlesDto>,
	CreateEntityAction<ArticleCreateUpdateDto>,
	RetrieveEntityAction<ArticleDto> {

	companion object {
		const val PATH: String = ApiController.PATH + "/articles"
	}
}