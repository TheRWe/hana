package cz.globex.hana.router.controller

import cz.globex.hana.common.dto.*
import cz.globex.hana.router.controller.action.general.*
import cz.globex.hana.router.controller.action.specific.*

internal interface StockExchangesApiController :
	RetrieveMultipleAction<StockExchangeFiltersDto, StockExchangesDto>,
	CreateAction<StockExchangeCreateUpdateDto, Long>,
	RetrieveAction<StockExchangeDto, Long>,
	UpdateAction<StockExchangeCreateUpdateDto, Long>,
	DeleteAction<Long>,
	RateAction<Long>,
	ReportAction<Long> {

	companion object {
		const val PATH: String = ApiController.PATH + "/stock-exchanges"
	}
}