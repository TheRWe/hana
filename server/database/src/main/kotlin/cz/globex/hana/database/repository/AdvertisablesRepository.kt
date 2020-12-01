package cz.globex.hana.database.repository

import cz.globex.hana.database.entity.*
import org.springframework.data.jpa.repository.*

interface AdvertisablesRepository : JpaRepository<Advertisable, Long>