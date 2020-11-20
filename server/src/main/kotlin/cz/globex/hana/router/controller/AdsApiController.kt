package cz.globex.hana.router.controller

import cz.globex.hana.common.dto.*
import cz.globex.hana.router.controller.action.*

interface AdsApiController :
	RetrieveMultipleAction<AdFiltersDto, AdsDto>,
	CreateAction<AdCreateUpdateDto>,
	RetrieveAction<AdDto>,
	UpdateAction<AdCreateUpdateDto>,
	DeleteAction,
	RateAction,
	ReportAction {

	companion object {
		const val PATH: String = ApiController.PATH + "/ads"
	}
}