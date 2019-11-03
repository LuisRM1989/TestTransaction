package com.test.restApi

import com.test.restApi.dao.PersonaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket



@SpringBootApplication
class RestApiApplication: CommandLineRunner{

	@Autowired
	val personaRepository: PersonaRepository? = null
	override fun run(vararg args: String?) {

	}

}
fun main(args: Array<String>) {
	runApplication<RestApiApplication>(*args)
}
