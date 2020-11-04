package cz.globex.hana.controller.impl

import cz.globex.hana.controller.*
import org.springframework.web.bind.annotation.*
import javax.servlet.http.*

@RestController
@RequestMapping("/api/docs")
class DocsApiControllerImpl : DocsApiController {
	@GetMapping
	override fun redirectToSwagger(resp: HttpServletResponse) {
		resp.sendRedirect("/api/docs/swagger-ui.html")
	}

	@GetMapping("/v2/api-docs")
	override fun redirectToApiDocs(resp: HttpServletResponse) {
		resp.sendRedirect("/v2/api-docs")
	}
}