package cz.globex.hana.core.dao

import cz.globex.hana.core.dao.action.*
import cz.globex.hana.core.dto.*

interface AdsDao :
	RetrieveMultipleDaoAction<AdFiltersDto, AdsDto>,
	CreateDaoAction<AdCreateUpdateDto>,
	RetrieveDaoAction<AdDto>