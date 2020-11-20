package cz.globex.hana

import org.springframework.boot.*
import org.springframework.boot.autoconfigure.*
import org.springframework.context.annotation.*

@SpringBootApplication
@PropertySource(value = ["classpath:application.properties"])
class HanaApplication

fun main(args: Array<String>) {
	runApplication<HanaApplication>(*args)
}
