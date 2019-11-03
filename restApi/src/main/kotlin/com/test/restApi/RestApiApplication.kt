package com.test.restApi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


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
