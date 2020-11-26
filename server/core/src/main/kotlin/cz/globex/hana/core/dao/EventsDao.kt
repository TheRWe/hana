package cz.globex.hana.core.dao

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.action.*

interface EventsDao :
	RetrieveMultipleDaoAction<EventFiltersDto, EventsDto>,
	CreateDaoAction<EventCreateUpdateDto>,
	RetrieveDaoAction<EventDto>