package cz.globex.hana.core.dao.impl

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.*
import org.springframework.context.annotation.*
import org.springframework.data.domain.*

@Configuration
class StockExchangesDaoImpl : StockExchangesDao {
	override fun retrieveMultiple(
		filters: StockExchangeFiltersDto,
		pageable: Pageable
	): StockExchangesDto {
		TODO("Not yet implemented")
	}

	override fun createOne(entity: StockExchangeCreateUpdateDto): Long {
		TODO("Not yet implemented")
	}

	override fun retrieveOneOrNull(id: Long): StockExchangeDto? {
		TODO("Not yet implemented")
	}
}