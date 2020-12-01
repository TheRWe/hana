package cz.globex.hana.router.controller

import org.springframework.core.io.*

internal interface WebController {
	fun getIndex(): Resource
}