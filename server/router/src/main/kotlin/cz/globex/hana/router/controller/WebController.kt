package cz.globex.hana.router.controller

import org.springframework.core.io.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

internal interface WebController {
	@GetMapping(
		path = ["/", "/{x:[\\w\\-]+}", "/{x:^(?!api$).*$}/**/{y:[\\w\\-]+}"],
		produces = [MediaType.TEXT_HTML_VALUE]
	)
	fun getIndex(): Resource
}