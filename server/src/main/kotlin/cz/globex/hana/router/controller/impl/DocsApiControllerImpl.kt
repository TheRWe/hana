package cz.globex.hana.router.controller.impl

import cz.globex.hana.router.controller.*
import org.springframework.web.bind.annotation.*
import javax.servlet.http.*

@RestController
@RequestMapping(path = [DocsApiController.PATH])
class DocsApiControllerImpl : DocsApiController {
	@GetMapping
	override fun redirectToSwagger(resp: HttpServletResponse) {
		resp.sendRedirect("${DocsApiController.PATH}/swagger-ui.html")
	}

	@GetMapping(path = ["/v2/api-docs"])
	override fun redirectToApiDocs(resp: HttpServletResponse) {
		resp.sendRedirect("/v2/api-docs")
	}
}