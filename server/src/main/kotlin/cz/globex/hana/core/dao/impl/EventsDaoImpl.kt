package cz.globex.hana.core.dao.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.*
import org.springframework.context.annotation.*
import org.springframework.data.domain.*

@Configuration
class EventsDaoImpl : EventsDao {
	override fun retrieveMultiple(filters: EventFiltersDto, pageable: Pageable): EventsDto {
		TODO("Not yet implemented")
	}

	override fun createOne(entity: EventCreateUpdateDto): Int {
		TODO("Not yet implemented")
	}

	override fun retrieveOneOrNull(id: Int): EventDto? {
		TODO("Not yet implemented")
	}
}