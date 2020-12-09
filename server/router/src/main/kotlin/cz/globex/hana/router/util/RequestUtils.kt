package cz.globex.hana.router.util

import cz.globex.hana.core.security.*
import org.springframework.http.*
import org.springframework.stereotype.*
import org.springframework.web.context.request.*
import org.springframework.web.server.*

@Component
internal class RequestUtils protected constructor(
	private val facebookUserProvider: FacebookUserProvider
) {
	fun getActualUserId(): Long {
		return getTokenOrNull()
			?.let { facebookUserProvider.getUserIdOrNull(it) }
			?: throw ResponseStatusException(HttpStatus.UNAUTHORIZED)
	}

	private fun getTokenOrNull(): String? {
		return ""

//		val reqAttrs = RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes
//		return reqAttrs.request.getHeader(HttpHeaders.AUTHORIZATION)?.substringAfter("Bearer ")
	}
}