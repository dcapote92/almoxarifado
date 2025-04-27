package com.angerbytes.almoxarifado.config

import com.angerbytes.almoxarifado.model.Product
import com.angerbytes.almoxarifado.model.Provider
import com.angerbytes.almoxarifado.model.User
import com.angerbytes.almoxarifado.repositories.ProductRepository
import com.angerbytes.almoxarifado.repositories.ProviderRepository
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
    @field:Autowired private val providerRepository: ProviderRepository
) : CommandLineRunner{


    @Transactional
    override fun run(vararg args: String?) {

        userRepository.deleteAll()
        productRepository.deleteAll()
        providerRepository.deleteAll()

        val users = listOf(
            User(null,"Marc", "123.123.123-12","marc@gmail.com","(12)1234 1234"),
            User(null,"Poll", "123.123.123-12","poll@gmail.com","(12)1234 1234")
        )

        val products = listOf(
            Product(null,"123","123456789","Popeye", "Espinaca em pô", "hervas", "kg"),
            Product(null,"124","123456781","Brutus", "Pinheiro deshidratado","lenha", "unidade")
        )

        val providers = listOf(
            Provider(null,"001","Juridico","000.000/0000-11","001","Bom Oleo","Olinho","Oliveira, 33","olivo@verde.com","Oliva Green","(11)1111 1111"),
            Provider(null,"002","Juridico","000.000/0000-12","002","Blue Berry","Amora","Oliveira, 34","berry@blue.com","Berry Blue","(22)2222 2222")
        )

        userRepository.saveAll(users)
        productRepository.saveAll(products)
        providerRepository.saveAll(providers)

        userRepository.flush()
        productRepository.flush()
        providerRepository.flush()

    }
}