package cz.globex.hana.core.dao

import cz.globex.hana.common.dto.*
import cz.globex.hana.core.dao.action.general.*
import cz.globex.hana.core.dao.action.specific.*

interface AdvertisablesDao<T : EntityDto, S : EntitiesDto, C : EntityCreateDto, U : EntityUpdateDto, F : EntityFiltersDto> :
	RetrieveMultipleDaoAction<F, S>,
	CreateDaoAction<C, Long>,
	RetrieveDaoAction<T, Long>,
	UpdateDaoAction<U, Long>,
	DeleteDaoAction<Long>,
	RateDaoAction<Long>,
	ReportDaoAction<Long>