package cz.globex.hana.controller

import javax.servlet.http.*

interface ApiController {
	companion object {
		const val PATH: String = "/api"
	}

	fun redirectToSwagger(resp: HttpServletResponse)
}