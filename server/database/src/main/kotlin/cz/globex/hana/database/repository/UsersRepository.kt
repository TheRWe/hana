package cz.globex.hana.database.repository

import cz.globex.hana.database.entity.impl.*
import org.springframework.data.jpa.repository.*
import org.springframework.data.repository.*

interface UsersRepository :
	JpaRepository<User, Long>,
	IdentifiablesRepository<User, Long>