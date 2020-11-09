package cz.globex.hana.router.controller

import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.action.*
import cz.globex.hana.router.dto.*

interface AdsApiController :
	RetrieveEntitiesAction<AdsRequestDto, AdsDto>,
	CreateEntityAction<AdCreateUpdateDto>,
	RetrieveEntityAction<AdDto>,
	UpdateEntityAction<AdCreateUpdateDto>,
	DeleteEntityAction,
	RateEntityAction,
	ReportEntityAction {

	companion object {
		const val PATH: String = ApiController.PATH + "/ads"
	}
}