package cz.globex.hana.controller.impl

import cz.globex.hana.controller.*
import org.springframework.web.bind.annotation.*
import javax.servlet.http.*

@RestController
@RequestMapping("/api")
class ApiControllerImpl : ApiController {
	@GetMapping
	override fun redirectToSwagger(resp: HttpServletResponse) {
		resp.sendRedirect("/api/docs/swagger-ui.html")
	}
}