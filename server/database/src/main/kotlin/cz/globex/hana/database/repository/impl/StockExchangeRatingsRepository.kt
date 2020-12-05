package cz.globex.hana.database.repository.impl

import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.*
import org.springframework.data.jpa.repository.*

interface StockExchangeRatingsRepository :
	JpaRepository<StockExchangeRating, Long>,
	RatingsRepository {

	@Query("SELECT ser FROM STOCKEXCHANGERATING ser, STOCKEXCHANGE se WHERE se.id = :advertisableId AND se.isDeleted = false AND se.id = ser.advertisable.id AND ser.id = :id")
	override fun getByIdAndAdvertisableId(id: Long, advertisableId: Long): StockExchangeRating
}