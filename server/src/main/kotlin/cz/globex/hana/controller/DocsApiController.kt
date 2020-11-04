package cz.globex.hana.controller

import javax.servlet.http.*

interface DocsApiController {
	companion object {
		const val PATH: String = ApiController.PATH + "/docs"
	}

	fun redirectToSwagger(resp: HttpServletResponse)

	fun redirectToApiDocs(resp: HttpServletResponse)
}