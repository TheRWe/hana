package cz.globex.hana

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@PropertySource(value = ["classpath:application.properties"], ignoreResourceNotFound = true)
class HanaApplication

fun main(args: Array<String>) {
	runApplication<HanaApplication>(*args)
}
