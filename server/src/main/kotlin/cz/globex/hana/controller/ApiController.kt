package cz.globex.hana.controller

import javax.servlet.http.*

interface ApiController {
	fun redirectToSwagger(resp: HttpServletResponse)
}