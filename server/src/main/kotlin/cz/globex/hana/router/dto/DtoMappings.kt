package cz.globex.hana.router.dto

import cz.globex.hana.core.dto.*
import cz.globex.hana.database.entity.*

fun Article.toDto(): ArticleDto = ArticleDto(title = title, text = text)