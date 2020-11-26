package cz.globex.hana.router.controller

import org.springframework.web.bind.annotation.*
import javax.servlet.http.*

interface DocsApiController {
	companion object {
		const val PATH: String = ApiController.PATH + "/docs"
	}

	@GetMapping
	fun redirectToSwagger(resp: HttpServletResponse)

	@GetMapping(path = ["/v2/api-docs"])
	fun redirectToApiDocs(resp: HttpServletResponse)
}