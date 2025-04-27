package com.angerbytes.almoxarifado

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("com.angerbytes.almoxarifado.repositories")
@EntityScan("com.angerbytes.almoxarifado.model")
class AlmoxarifadoApplication

fun main(args: Array<String>) {
	runApplication<AlmoxarifadoApplication>(*args)
}
