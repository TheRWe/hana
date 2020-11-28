package cz.globex.hana.router.controller.impl

import cz.globex.hana.router.controller.*
import org.springframework.stereotype.*

@Controller
class WebControllerImpl : WebController {
	@Suppress("PublicApiImplicitType")
	override fun getIndex() = @Suppress("SpringMVCViewInspection") "index"
}