package cz.globex.hana.controller

import javax.servlet.http.*

interface DocsApiController {
	fun redirectToSwagger(resp: HttpServletResponse)

	fun redirectToApiDocs(resp: HttpServletResponse)
}