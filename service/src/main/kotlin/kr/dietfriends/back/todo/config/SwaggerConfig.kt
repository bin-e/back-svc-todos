package kr.dietfriends.back.todo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
@EnableWebMvc
class SwaggerConfig {

    @Bean
    fun api(): Docket? {
        return Docket(DocumentationType.OAS_30)
            .useDefaultResponseMessages(false)
            .select()
            .apis(RequestHandlerSelectors.basePackage("kr.dietfriends.back"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo())
    }

    private fun apiInfo(): ApiInfo? {
        return ApiInfoBuilder()
            .title("To-do Demo")
            .description(
                """
    This OAS2 (Swagger 2) file represents a real API that lives at http://todos.stoplight.io.

    For authentication information, click the apikey security scheme in the editor sidebar.
            """.trimIndent()
            )
            .version("1.0.0")
//            .contact(Contact())
            .license("MIT")
            .build()
    }

}