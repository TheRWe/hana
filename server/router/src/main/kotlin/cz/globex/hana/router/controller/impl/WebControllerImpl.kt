package cz.globex.hana.router.controller.impl

import cz.globex.hana.router.controller.*
import org.springframework.stereotype.*

@Controller
internal class WebControllerImpl private constructor() : WebController {
	@Suppress("PublicApiImplicitType")
	override fun getIndex() = @Suppress("SpringMVCViewInspection") "index"
}