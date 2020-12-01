package cz.globex.hana.database.repository

import cz.globex.hana.database.entity.impl.*
import org.springframework.data.jpa.repository.*

interface StockExchangeRatingsRepository :
	JpaRepository<StockExchangeRating, Long>,
	RatingsRepository {

	override fun getByIdAndAdvertisableId(id: Long, advertisableId: Long): StockExchangeRating
}