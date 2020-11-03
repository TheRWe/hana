package cz.globex.hana.dto

import cz.globex.hana.CommonInterface
import java.util.*

@CommonInterface
data class GetExampleRequestDto(
	override val id: Int,
	val validTo: Date,
	val customString: String,
	val author: Author,
	val from: Int,
): Id

interface Id {
	val id: Int
}

enum class Author { USER, ADMIN, }