package cz.globex.hana.router.controller

import cz.globex.hana.common.dto.*
import cz.globex.hana.router.controller.action.*

interface EventsApiController :
	RetrieveMultipleAction<EventFiltersDto, EventsDto>,
	CreateAction<EventCreateUpdateDto>,
	RetrieveAction<EventDto>,
	UpdateAction<EventCreateUpdateDto>,
	DeleteAction,
	RateAction,
	ReportAction {

	companion object {
		const val PATH: String = ApiController.PATH + "/events"
	}
}