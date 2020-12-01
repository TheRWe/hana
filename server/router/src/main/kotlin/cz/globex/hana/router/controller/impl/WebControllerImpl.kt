package cz.globex.hana.router.controller.impl

import cz.globex.hana.router.controller.*
import org.springframework.beans.factory.annotation.*
import org.springframework.core.io.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
internal class WebControllerImpl private constructor(
	@Value("classpath:/build/index.html") private val index: Resource,
) : WebController {
	@GetMapping(
		path = ["/", "/{x:[\\w\\-]+}", "/{x:^(?!api$).*$}/**/{y:[\\w\\-]+}"],
		produces = [MediaType.TEXT_HTML_VALUE]
	)
	override fun getIndex(): Resource = index
}