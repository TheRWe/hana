package cz.globex.hana.core.dao

import cz.globex.hana.core.dao.action.*
import cz.globex.hana.core.dto.*

interface EventsDao :
	RetrieveMultipleDaoAction<EventFiltersDto, EventsDto>,
	CreateDaoAction<EventCreateUpdateDto>,
	RetrieveDaoAction<EventDto>