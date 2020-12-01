package cz.globex.hana.database.repository

import cz.globex.hana.database.entity.*
import cz.globex.hana.database.entity.impl.*
import org.springframework.data.jpa.repository.*

interface RatingsRepository {
	fun getByIdAndAdvertisableId(id: Long, advertisableId: Long): Rating
}