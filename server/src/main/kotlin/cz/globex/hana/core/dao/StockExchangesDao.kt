package cz.globex.hana.core.dao

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.action.*

interface StockExchangesDao :
	RetrieveMultipleDaoAction<StockExchangeFiltersDto, StockExchangesDto>,
	CreateDaoAction<StockExchangeCreateUpdateDto>,
	RetrieveDaoAction<StockExchangeDto>