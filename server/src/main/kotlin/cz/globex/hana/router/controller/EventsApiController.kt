package cz.globex.hana.router.controller

import cz.globex.hana.core.dto.*
import cz.globex.hana.router.controller.action.*
import cz.globex.hana.router.dto.*

interface EventsApiController :
	RetrieveEntitiesAction<EventsRequestDto, EventsDto>,
	CreateEntityAction<EventCreateUpdateDto>,
	RetrieveEntityAction<EventDto>,
	UpdateEntityAction<EventCreateUpdateDto>,
	DeleteEntityAction,
	RateEntityAction,
	ReportEntityAction {

	companion object {
		const val PATH: String = ApiController.PATH + "/events"
	}
}