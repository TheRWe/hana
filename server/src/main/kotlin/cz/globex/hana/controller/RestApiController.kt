package cz.globex.hana.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class RestApiController {
	@GetMapping
	fun getGreet(): String = """{"greet":"hello"}"""
}