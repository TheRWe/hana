package cz.globex.hana.router.controller.action

import cz.globex.hana.core.dto.*
import org.springframework.http.*

fun interface RateEntityAction {
	fun rateEntity(id: Int, rate: RateDto): ResponseEntity<ResourceInfoDto>
}