package com.angerbytes.almoxarifado.config

import com.angerbytes.almoxarifado.model.*
import com.angerbytes.almoxarifado.model.enums.*
import com.angerbytes.almoxarifado.repositories.*
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import java.math.BigDecimal
import java.time.Instant
import java.util.*


@Configuration
@Profile("dev")
class TestConfig(
    @field:Autowired private val userRepository: UserRepository,
    @field:Autowired private val productRepository: ProductRepository,
    @field:Autowired private val providerRepository: ProviderRepository,
    @field:Autowired private val fiscalNoteRepository: FiscalNoteRepository,
    @field:Autowired private val locationRepository: LocationRepository,
    @field:Autowired private val movementRepository: MovementRepository
) : CommandLineRunner{

    @Transactional
    override fun run(vararg args: String?) {

        userRepository.deleteAll()
        productRepository.deleteAll()
        providerRepository.deleteAll()
        fiscalNoteRepository.deleteAll()
        locationRepository.deleteAll()
        movementRepository.deleteAll()

        val users = listOf(
            User(null,"Marc", "123.123.123-12","marc@gmail.com","(12)1234 1234","marcopolo","123456"),
            User(null,"Poll", "123.123.123-12","poll@gmail.com","(12)1234 1234","polaco","123456")
        )

        val products = listOf(
            Product(null,"123","123456789","Popeye", "Espinaca em pô", "hervas", UnitMeasures.KG, BigDecimal("25.50")),
            Product(null,"124","123456781","Brutus", "Pinheiro deshidratado","lenha", UnitMeasures.UNIDADE,BigDecimal("10.00"))
        )

        val providers = listOf(
            Provider(null,"001", ProviderType.PESSOA_JURIDICA,"12.345.678/0001-90","001","Bom Oleo","Olinho","Oliveira, 33","olivo@verde.com","Oliva Green","(11)1111 1111"),
            Provider(null,"002",ProviderType.PESSOA_JURIDICA,"12.345.678/0001-91","002","Blue Berry","Amora","Oliveira, 34","berry@blue.com","Berry Blue","(22)2222 2222")
        )

        val fiscalNotes = listOf(
            FiscalNote(null,  UUID.randomUUID().toString(),1,"123456a", FiscalNoteModel.NFE, Instant.now(),
                Instant.now(),providers[0], BigDecimal("120.00"),BigDecimal("9.99"),BigDecimal("150.00"),BigDecimal("50.00"), products,
                FiscalNoteStatus.AUTORIZADA,"0000000000","1111111111",users[0])
        )

        val locations = listOf(
            Location(null,Sections.FERRAMENTAS,'A',1,1),
            Location(null,Sections.FERRAMENTAS,'A',1,2)
        )

        val movements = listOf(
            Movement(null, MovementType.INVENTARIO,"asd123", Instant.now(),users[1],products,
                MovementStatus.PENDENTE,"Cambio de diretiva","111000002222")
        )

        userRepository.saveAll(users)
        productRepository.saveAll(products)
        providerRepository.saveAll(providers)
        fiscalNoteRepository.saveAll(fiscalNotes)
        locationRepository.saveAll(locations)
        movementRepository.saveAll(movements)

        userRepository.flush()
        productRepository.flush()
        providerRepository.flush()
        fiscalNoteRepository.flush()
        locationRepository.flush()
        movementRepository.flush()

    }
}