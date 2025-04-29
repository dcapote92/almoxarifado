package com.angerbytes.almoxarifado.config

import com.angerbytes.almoxarifado.model.FiscalNote
import com.angerbytes.almoxarifado.model.Product
import com.angerbytes.almoxarifado.model.Provider
import com.angerbytes.almoxarifado.model.User
import com.angerbytes.almoxarifado.model.enums.FiscalNoteModel
import com.angerbytes.almoxarifado.model.enums.FiscalNoteStatus
import com.angerbytes.almoxarifado.repositories.FiscalNoteRepository
import com.angerbytes.almoxarifado.repositories.ProductRepository
import com.angerbytes.almoxarifado.repositories.ProviderRepository
import com.angerbytes.almoxarifado.repositories.UserRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import java.math.BigDecimal
import java.time.Instant


@Configuration
@Profile("dev")
class TestConfig(
    @field:Autowired private val userRepository: UserRepository,
    @field:Autowired private val productRepository: ProductRepository,
    @field:Autowired private val providerRepository: ProviderRepository,
    @field:Autowired private val fiscalNoteRepository: FiscalNoteRepository
) : CommandLineRunner{


    @Transactional
    override fun run(vararg args: String?) {

        userRepository.deleteAll()
        productRepository.deleteAll()
        providerRepository.deleteAll()
        fiscalNoteRepository.deleteAll()

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

        val fiscalNotes = listOf(
            FiscalNote(null,"123456789123456789",1,"123456a", FiscalNoteModel.NFE, Instant.now(),
                Instant.now(),providers.get(0), BigDecimal("800.00"),BigDecimal("120.00"),BigDecimal("99.00"),BigDecimal("150.00"),BigDecimal("50.00"), products,
                FiscalNoteStatus.AUTORIZED,"0000000000","1111111111",users.get(0))
        )

        userRepository.saveAll(users)
        productRepository.saveAll(products)
        providerRepository.saveAll(providers)
        fiscalNoteRepository.saveAll(fiscalNotes)

        userRepository.flush()
        productRepository.flush()
        providerRepository.flush()
        fiscalNoteRepository.flush()

    }
}