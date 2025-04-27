package com.angerbytes.almoxarifado.config

import com.angerbytes.almoxarifado.model.Product
import com.angerbytes.almoxarifado.model.User
import com.angerbytes.almoxarifado.repositories.ProductRepository
import com.angerbytes.almoxarifado.repositories.UserRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile


@Configuration
@Profile("dev")
class TestConfig(
    @field:Autowired private val userRepository: UserRepository,
    @field:Autowired private val productRepository: ProductRepository,
) : CommandLineRunner{


    @Transactional
    override fun run(vararg args: String?) {

        userRepository.deleteAll()
        productRepository.deleteAll()

        val users = listOf(
            User(null,"Marc", "123.123.123-12","marc@gmail.com","(12)1234 1234"),
            User(null,"Poll", "123.123.123-12","poll@gmail.com","(12)1234 1234")
        )

        val products = listOf(
            Product(null,"123","123456789","Popeye", "Espinaca em pô", "hervas", "kg"),
            Product(null,"124","123456781","Brutus", "Pinheiro deshidratado","lenha", "unidade")
        )

        userRepository.saveAll(users)
        productRepository.saveAll(products)

        userRepository.flush()
        productRepository.flush()

        // Log para verificação
        println("Users no banco: ${userRepository.findAll()}")
        println("Products no banco: ${productRepository.findAll()}")

    }
}