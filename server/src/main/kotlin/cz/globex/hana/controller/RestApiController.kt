package cz.globex.hana.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api", produces = [MediaType.APPLICATION_JSON_VALUE])
class RestApiController {
	@GetMapping
	fun getGreet(): String = """{"greet":"hello"}"""
}