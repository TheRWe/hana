package cz.globex.hana.router.util

fun Iterable<String>.stringify(): String {
	return joinToString(separator = ", ", prefix = "[", postfix = "]")
}