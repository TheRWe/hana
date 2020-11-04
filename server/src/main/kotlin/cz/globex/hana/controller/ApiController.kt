package cz.globex.hana.controller

import cz.globex.hana.controller.util.*
import java.net.*
import javax.servlet.http.*

interface ApiController {
	companion object {
		const val PATH: String = "/api"
	}

	fun redirectToSwagger(resp: HttpServletResponse)
}

@CommonInterface
data class CreateResponseDto(
	val resourceInfo: ResourceInfoDto
)

data class ResourceInfoDto(
	val id: Int,
	val uri: URI,
)