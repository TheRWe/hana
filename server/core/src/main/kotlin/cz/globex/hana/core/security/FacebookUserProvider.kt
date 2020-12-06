package cz.globex.hana.core.security

import com.fasterxml.jackson.annotation.*
import com.fasterxml.jackson.module.kotlin.*
import com.squareup.okhttp.*
import cz.globex.hana.common.dto.*
import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.impl.*
import org.springframework.stereotype.*
import java.util.concurrent.*

@Component
class FacebookUserProvider protected constructor(
	private val usersRepository: UsersRepository,
) {
	private val loggedInUsers = ConcurrentHashMap<String, Long>()

	fun getUserIdOrNull(token: String): Long? {
		val userId = loggedInUsers[token]
		if (userId != null) return userId

		val data = FacebookApiClient.getDataOrNull(token) ?: return null
		val oldUser = usersRepository.findById(data.id)
		val user = if (oldUser.isPresent) {
			val (firstName, lastName) = getSplitName(data.name)
			oldUser.get().apply {
				email = data.email
				this.firstName = firstName
				this.lastName = lastName
			}
		} else {
			val (firstName, lastName) = getSplitName(data.name)
			with(data) {
				User(
					id = id,
					email = email,
					firstName = firstName,
					lastName = lastName,
					type = UserType.PERSON,
				)
			}
		}
		return usersRepository.save(user).id
	}

	private fun getSplitName(fullName: String): Pair<String, String> {
		val splitName = fullName.split(' ')
		return splitName.dropLast(1).joinToString(" ") to splitName.last()
	}
}

object FacebookApiClient {
	private val client = OkHttpClient()
	private val objectMapper = jacksonObjectMapper()

	fun getDataOrNull(token: String): FacebookData? {
		val url: HttpUrl = HttpUrl
			.parse("https://graph.facebook.com/me")
			.newBuilder()
			.addQueryParameter("fields", "id,name,email")
			.addQueryParameter("access_token", token)
			.build()
		val request: Request = Request.Builder().url(url).build()
		val response: Response = client.newCall(request).execute()
		return if (response.code() in 200 until 300) {
			objectMapper.readValue(response.body().string())
		} else {
			null
		}
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
data class FacebookData(
	val id: Long,
	val name: String,
	val email: String,
)