package cz.globex.hana.core.dao

import cz.globex.hana.common.dto.*

interface StockExchangesDao :
	AdvertisablesDao<StockExchangeDto, StockExchangesDto, StockExchangeCreateUpdateDto, StockExchangeCreateUpdateDto, StockExchangeFiltersDto>