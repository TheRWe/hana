package cz.globex.hana.database.repository.impl

import cz.globex.hana.database.entity.impl.*
import org.springframework.data.repository.*

interface TagsRepository : CrudRepository<Tag, Long>