package cz.globex.hana.router.controller.impl

import cz.globex.hana.router.controller.*
import org.springframework.stereotype.*
import org.springframework.web.bind.annotation.*

@Controller
class WebControllerImpl : WebController {
	override fun getIndex() = "index"
}