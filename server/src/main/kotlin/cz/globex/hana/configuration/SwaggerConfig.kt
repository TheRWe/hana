package cz.globex.hana.configuration

import org.springframework.context.annotation.*
import springfox.documentation.builders.*
import springfox.documentation.spi.*
import springfox.documentation.spring.web.plugins.*
import springfox.documentation.swagger2.annotations.*

@Configuration
@EnableSwagger2
class SwaggerConfig {
	@Bean
	fun api(): Docket {
		return Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.any())
			// TODO: hide redirects from paths
			.paths(PathSelectors.ant("/api/**"))
			.build()
			.apiInfo(
				ApiInfoBuilder()
					.title("Hana REST API")
					.version("0.1.0")
					.build()
			)
	}
}