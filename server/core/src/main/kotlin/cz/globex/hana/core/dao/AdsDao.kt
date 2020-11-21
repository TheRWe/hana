package cz.globex.hana.core.dao

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.action.*

interface AdsDao :
	RetrieveMultipleDaoAction<AdFiltersDto, AdsDto>,
	CreateDaoAction<AdCreateUpdateDto>,
	RetrieveDaoAction<AdDto>