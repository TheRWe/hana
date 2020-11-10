package cz.globex.hana.core.dao

import cz.globex.hana.core.dao.action.*
import cz.globex.hana.core.dto.*

interface StockExchangesDao :
	RetrieveMultipleDaoAction<StockExchangeFiltersDto, StockExchangesDto>,
	CreateDaoAction<StockExchangeCreateUpdateDto>,
	RetrieveDaoAction<StockExchangeDto>