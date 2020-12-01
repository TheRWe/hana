package cz.globex.hana.database.repository

import cz.globex.hana.database.entity.impl.*
import org.springframework.data.jpa.repository.*

interface AdRatingsRepository : JpaRepository<AdRating, Long>, RatingsRepository {
	override fun getByIdAndAdvertisableId(id: Long, advertisableId: Long): AdRating
}