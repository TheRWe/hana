package cz.globex.hana.router.exception

import cz.globex.hana.common.dto.*
import cz.globex.hana.router.util.*
import org.springframework.http.*
import org.springframework.web.server.*
import java.text.*

internal class ParamsCombinationRequiredException private constructor(
	status: HttpStatus,
	msg: String
) : ResponseStatusException(status, msg) {
	companion object {
		private const val TEMPLATE =
			"Parameter(s) {0} must be provided when using the {1} parameter(s)."

		fun getInstance(
			status: HttpStatus,
			pagination: PaginationDto
		): ParamsCombinationRequiredException {
			return with(pagination) {
				val pageStartParam = ::pageStart.name
				val pageSizeParam = ::pageSize.name
				val (missingParams, providedParams) = if (pageStart == null) {
					setOf(pageStartParam) to setOf(pageSizeParam)
				} else {
					setOf(pageSizeParam) to setOf(pageStartParam)
				}
				getInstance(status, missingParams = missingParams, providedParams = providedParams)
			}
		}

		@Suppress("MemberVisibilityCanBePrivate")
		fun getInstance(
			status: HttpStatus,
			missingParams: Set<String>,
			providedParams: Set<String>
		): ParamsCombinationRequiredException {
			val requiredParamsStr = missingParams.stringify()
			val providedParamsStr = providedParams.stringify()
			val msg = MessageFormat.format(TEMPLATE, requiredParamsStr, providedParamsStr)
			return ParamsCombinationRequiredException(status, msg)
		}
	}
}