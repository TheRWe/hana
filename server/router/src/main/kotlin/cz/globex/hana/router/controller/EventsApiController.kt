package cz.globex.hana.router.controller

import cz.globex.hana.common.dto.*
import cz.globex.hana.router.controller.action.general.*
import cz.globex.hana.router.controller.action.specific.*

internal interface EventsApiController :
	RetrieveMultipleAction<EventFiltersDto, EventsDto>,
	CreateAction<EventCreateUpdateDto, Long>,
	RetrieveAction<EventDto, Long>,
	UpdateAction<EventCreateUpdateDto, Long>,
	DeleteAction<Long>,
	RateAction<Long>,
	ReportAction<Long> {

	companion object {
		const val PATH: String = ApiController.PATH + "/events"
	}
}