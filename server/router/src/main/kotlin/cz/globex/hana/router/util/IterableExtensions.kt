package cz.globex.hana.router.util

internal fun Iterable<String>.stringify(): String {
	return joinToString(separator = ", ", prefix = "[", postfix = "]")
}