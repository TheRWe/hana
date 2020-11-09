package cz.globex.hana.controller.impl

import cz.globex.hana.controller.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import javax.servlet.http.*

@RestController
@RequestMapping(path = [ApiController.PATH], produces = [MediaType.APPLICATION_JSON_VALUE])
class ApiControllerImpl : ApiController {
	@GetMapping
	override fun redirectToSwagger(resp: HttpServletResponse) {
		resp.sendRedirect("${DocsApiController.PATH}/swagger-ui.html")
	}
}