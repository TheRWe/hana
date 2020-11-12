package cz.globex.hana.router.controller

import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.action.*

interface StockExchangesApiController :
	RetrieveMultipleAction<StockExchangeFiltersDto, StockExchangesDto>,
	CreateAction<StockExchangeCreateUpdateDto>,
	RetrieveAction<StockExchangeDto>,
	UpdateAction<StockExchangeCreateUpdateDto>,
	DeleteAction,
	RateAction,
	ReportAction {

	companion object {
		const val PATH: String = ApiController.PATH + "/stock-exchanges"
	}
}