package cz.globex.hana.router.controller

import org.springframework.web.bind.annotation.*

interface WebController {
	@GetMapping(path = ["/", "/{x:[\\w\\-]+}", "/{x:^(?!api$).*$}/**/{y:[\\w\\-]+}"])
	fun getIndex(): String
}