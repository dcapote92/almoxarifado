package com.angerbytes.almoxarifado.config

import com.angerbytes.almoxarifado.model.User
import com.angerbytes.almoxarifado.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("test")
class TestConfig(@field:Autowired private val userRepository: UserRepository) : CommandLineRunner{

    override fun run(vararg args: String?) {
        val user = User(null,"Marc", "123.123.123-12","marc@gmail.com","(12)1234 1234")
        userRepository.save(user)

    }
}