package cz.globex.hana.router.deserializer

import com.fasterxml.jackson.core.*
import com.fasterxml.jackson.databind.*

class StringDeserializer : JsonDeserializer<String>() {
	override fun deserialize(parser: JsonParser, context: DeserializationContext?): String {
		val value: String = parser.text.trim()
		if (value.isEmpty()) throw IllegalArgumentException()

		return value
	}
}