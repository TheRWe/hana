package cz.globex.hana.core.dao

import cz.globex.hana.common.dto.*

interface EventsDao :
	AdvertisablesDao<EventDto, EventsDto, EventCreateUpdateDto, EventCreateUpdateDto, EventFiltersDto>