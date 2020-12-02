package cz.globex.hana.database.repository

import cz.globex.hana.database.entity.*

interface RatingsRepository {
	fun getByIdAndAdvertisableId(id: Long, advertisableId: Long): Rating
}