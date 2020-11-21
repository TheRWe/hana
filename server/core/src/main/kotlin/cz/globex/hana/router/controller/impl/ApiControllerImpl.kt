package cz.globex.hana.router.controller.impl

import cz.globex.hana.router.controller.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import javax.servlet.http.*

@RestController
@RequestMapping(path = [ApiController.PATH], produces = [MediaType.APPLICATION_JSON_VALUE])
class ApiControllerImpl : ApiController {
	override fun redirectToSwagger(resp: HttpServletResponse) {
		resp.sendRedirect("${DocsApiController.PATH}/swagger-ui.html")
	}
}