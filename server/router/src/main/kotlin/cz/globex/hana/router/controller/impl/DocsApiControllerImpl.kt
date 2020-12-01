package cz.globex.hana.router.controller.impl

import cz.globex.hana.router.controller.*
import org.springframework.web.bind.annotation.*
import javax.servlet.http.*

@RestController
@RequestMapping(path = [DocsApiController.PATH])
internal class DocsApiControllerImpl private constructor() : DocsApiController {
	@GetMapping
	override fun redirectToSwagger(resp: HttpServletResponse) {
		resp.sendRedirect("${DocsApiController.PATH}/swagger-ui.html")
	}

	@GetMapping(path = ["/v2/api-docs", "/swagger-resources/**"])
	override fun redirectToApiDocs(req: HttpServletRequest, resp: HttpServletResponse) {
		resp.sendRedirect(req.servletPath.removePrefix(DocsApiController.PATH))
	}
}