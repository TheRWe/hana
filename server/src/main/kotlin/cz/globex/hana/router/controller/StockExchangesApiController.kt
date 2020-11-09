package cz.globex.hana.router.controller

import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.action.*
import cz.globex.hana.router.dto.*

interface StockExchangesApiController :
	RetrieveEntitiesAction<StockExchangesRequestDto, StockExchangesDto>,
	CreateEntityAction<StockExchangeCreateUpdateDto>,
	RetrieveEntityAction<StockExchangeDto>,
	UpdateEntityAction<StockExchangeCreateUpdateDto>,
	DeleteEntityAction,
	RateEntityAction,
	ReportEntityAction {

	companion object {
		const val PATH: String = ApiController.PATH + "/stock-exchanges"
	}
}