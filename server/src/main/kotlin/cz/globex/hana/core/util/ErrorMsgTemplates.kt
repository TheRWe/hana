package cz.globex.hana.core.util

import java.text.*

object ErrorMsgTemplates {
	private const val PARAMS_COMBINATION_REQUIRED_TEMPLATE =
		"Parameter(s) {0} must be provided when using the {1} parameter(s)."

	fun paramsCombinationRequired(missing: Set<String>, provided: Set<String>): String {
		val template = PARAMS_COMBINATION_REQUIRED_TEMPLATE
		val requiredParamsStr = missing.stringify()
		val providedParamsStr = provided.stringify()
		return MessageFormat.format(template, requiredParamsStr, providedParamsStr)
	}
}

private fun Iterable<String>.stringify(): String {
	return joinToString(separator = ", ", prefix = "[", postfix = "]")
}