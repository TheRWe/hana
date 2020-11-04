package cz.globex.hana.configuration

import org.springframework.context.annotation.*
import org.springframework.web.servlet.config.annotation.*

@EnableWebMvc
@Configuration
class WebMvcConfig : WebMvcConfigurer {
	override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
		registry
			.addResourceHandler("/build/**")
			.addResourceLocations("classpath:/build/index.html")
		registry
			.addResourceHandler("/**")
			.addResourceLocations("classpath:/build/")
		registry
			.addResourceHandler("/api/docs/swagger-ui.html**")
			.addResourceLocations("classpath:/META-INF/resources/swagger-ui.html")
		registry
			.addResourceHandler("/api/docs/webjars/**")
			.addResourceLocations("classpath:/META-INF/resources/webjars/")
	}
}

