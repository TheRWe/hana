package cz.globex.hana.router.controller

import cz.globex.hana.common.dto.*
import cz.globex.hana.router.controller.action.general.*
import cz.globex.hana.router.controller.action.specific.*

internal interface AdsApiController :
	RetrieveMultipleAction<AdFiltersDto, AdsDto>,
	CreateAction<AdCreateUpdateDto, Long>,
	RetrieveAction<AdDto, Long>,
	UpdateAction<AdCreateUpdateDto, Long>,
	DeleteAction<Long>,
	RateAction<Long>,
	ReportAction<Long> {

	companion object {
		const val PATH: String = ApiController.PATH + "/ads"
	}
}