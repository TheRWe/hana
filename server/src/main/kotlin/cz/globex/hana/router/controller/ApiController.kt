package cz.globex.hana.router.controller

import org.springframework.web.bind.annotation.*
import javax.servlet.http.*

interface ApiController {
	companion object {
		const val PATH: String = "/api"
	}

	@GetMapping
	fun redirectToSwagger(resp: HttpServletResponse)
}