package cz.globex.hana.database.repository

import cz.globex.hana.database.entity.*

interface IdentifiablesRepository<T : Persistable, ID : Comparable<ID>>