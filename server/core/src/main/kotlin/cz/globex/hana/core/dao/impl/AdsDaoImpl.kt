package cz.globex.hana.core.dao.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.*
import org.springframework.context.annotation.*
import org.springframework.data.domain.*

@Configuration
class AdsDaoImpl : AdsDao {
	override fun retrieveMultiple(filters: AdFiltersDto, pageable: Pageable): AdsDto {
		TODO("Not yet implemented")
	}

	override fun createOne(entity: AdCreateUpdateDto): Long {
		TODO("Not yet implemented")
	}

	override fun retrieveOneOrNull(id: Long): AdDto? {
		TODO("Not yet implemented")
	}
}