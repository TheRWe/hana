package cz.globex.hana.router.exception.handler

import org.h2.jdbc.*
import org.springframework.dao.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import javax.persistence.*
import javax.servlet.http.*

@ControllerAdvice
class GlobalExceptionHandler {
	@ExceptionHandler(JdbcSQLIntegrityConstraintViolationException::class)
	fun handleBadRequestException(resp: HttpServletResponse) {
		resp.sendError(HttpStatus.BAD_REQUEST.value())
	}

	@ExceptionHandler(
		value = [EntityNotFoundException::class, EmptyResultDataAccessException::class]
	)
	fun handleNotFoundException(resp: HttpServletResponse) {
		resp.sendError(HttpStatus.NOT_FOUND.value())
	}
}