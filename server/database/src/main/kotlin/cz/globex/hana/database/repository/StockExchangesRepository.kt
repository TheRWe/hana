package cz.globex.hana.database.repository

import cz.globex.hana.database.entity.impl.*
import org.springframework.data.jpa.repository.*

interface StockExchangesRepository : JpaRepository<StockExchange, Long>