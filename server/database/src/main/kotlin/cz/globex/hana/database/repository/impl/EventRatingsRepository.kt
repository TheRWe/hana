package cz.globex.hana.database.repository.impl

import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.*
import org.springframework.data.jpa.repository.*

interface EventRatingsRepository : JpaRepository<EventRating, Long>, RatingsRepository {
	@Query("SELECT er FROM EVENTRATING er, Event e WHERE e.id = :advertisableId AND e.isDeleted = false AND e.id = er.advertisable.id AND er.id = :id")
	override fun getByIdAndAdvertisableId(id: Long, advertisableId: Long): EventRating
}