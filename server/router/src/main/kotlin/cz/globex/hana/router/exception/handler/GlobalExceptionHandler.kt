package cz.globex.hana.router.exception.handler

import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.method.annotation.*
import javax.persistence.*
import javax.servlet.http.*

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {
	@ExceptionHandler(EntityNotFoundException::class)
	fun handleEntityNotFoundException(e: EntityNotFoundException, resp: HttpServletResponse) {
		val msg = e
			.message
			?.split(' ')
			?.joinToString(separator = " ") { it.split('.').last() }
		resp.sendError(HttpStatus.NOT_FOUND.value(), msg)
	}
}