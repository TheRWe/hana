package cz.globex.hana.database.repository.impl

import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.*
import org.springframework.data.jpa.repository.*

interface AdRatingsRepository : JpaRepository<AdRating, Long>, RatingsRepository {
	@Query("SELECT ar FROM ADRATING ar, Ad a WHERE a.id = :advertisableId AND a.isDeleted = false AND a.id = ar.advertisable.id AND ar.id = :id")
	override fun getByIdAndAdvertisableId(id: Long, advertisableId: Long): AdRating
}