package cz.globex.hana.database.repository

import cz.globex.hana.database.entity.impl.*
import org.springframework.data.repository.*

interface TagsRepository : CrudRepository<Tag, Long>, IdentifiablesRepository<Tag, String>