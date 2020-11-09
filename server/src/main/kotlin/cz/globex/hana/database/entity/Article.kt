package cz.globex.hana.database.entity

import javax.persistence.*

@Suppress("ProtectedInFinal")
@Entity
data class Article(
	@Column(nullable = false)
	var title: String,

	@Column(nullable = false)
	var text: String,
) {
	@Id
	@GeneratedValue
	@Column(updatable = false)
	val id: Int = 0

	@Suppress("RemoveEmptyClassBody")
	companion object {}

	protected constructor() : this("", "")
}