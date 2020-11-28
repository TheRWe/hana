package cz.globex.hana.router.controller.impl

import cz.globex.hana.router.controller.*
import org.springframework.web.bind.annotation.*
import javax.servlet.http.*

@RestController
@RequestMapping(path = [DocsApiController.PATH])
class DocsApiControllerImpl : DocsApiController {
	override fun redirectToSwagger(resp: HttpServletResponse) {
		resp.sendRedirect("${DocsApiController.PATH}/swagger-ui.html")
	}

	override fun redirectToApiDocs(req: HttpServletRequest, resp: HttpServletResponse) {
		resp.sendRedirect(req.servletPath.removePrefix(DocsApiController.PATH))
	}
}