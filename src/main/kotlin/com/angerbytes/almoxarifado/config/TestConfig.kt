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
    @field:Autowired private val collaboratorRepository: CollaboratorRepository,
    @field:Autowired private val movementRepository: MovementRepository
) : CommandLineRunner{

    @Transactional
    override fun run(vararg args: String?) {

        collaboratorRepository.deleteAll()
        userRepository.deleteAll()
        productRepository.deleteAll()
        providerRepository.deleteAll()
        fiscalNoteRepository.deleteAll()
        movementRepository.deleteAll()

        val collaborators = listOf(
            Collaborator(null,"Marcos Polo Silva","123.456.789-00","0001","Técnico de Almoxarifado"),
            Collaborator(null,"Pedro","321.654.987-11","0002","Auxiliar de Produção I"),
            Collaborator(null,"Paulo","213.546.879-01","0003","Operador de Máquina II"),
            Collaborator(null,"Maria","312.645.978-31","0004","Auxiliar de Produção II"),
            Collaborator(null,"Ana","132.465.798-79","0005","Operador de Máquina I"),
        )

        val users = listOf(
            User(null, collaborators[0],"marcopolo@gmail.com","(00) 1234-5678","marcopolo","123456"),
        )

        val locations = listOf(
            Location(Sections.FERRAMENTAS,'A',1,1),
            Location(Sections.FERRAMENTAS,'A',1,2)
        )

        val providers = listOf(
            Provider(null,"001", ProviderType.PESSOA_JURIDICA,"12.345.678/0001-90","001","Bom Oleo","Olinho","Oliveira, 33","olivo@verde.com","Oliva Green","(11)1111 1111"),
            Provider(null,"002",ProviderType.PESSOA_JURIDICA,"12.345.678/0001-91","002","Blue Berry","Amora","Oliveira, 34","berry@blue.com","Berry Blue","(22)2222 2222")
        )

        val products = listOf(
            Product(null,"123","123456789","Popeye", "Espinaca em pô", "hervas",BigDecimal("200"),BigDecimal("20"),BigDecimal("500"),locations[0],
                Instant.now(),Instant.now(),providers[0],listOf(providers[1]),BigDecimal(".200"),BigDecimal("3"),
                UnitMeasures.KG,BigDecimal("25.90"), true)

        )

        val fiscalNotes = listOf(
            FiscalNote(null,  UUID.randomUUID().toString(),1,"123456a", FiscalNoteModel.NFE, Instant.now(),
                Instant.now(),providers[0], BigDecimal("120.00"),BigDecimal("9.99"),BigDecimal("150.00"),BigDecimal("50.00"), products,
                FiscalNoteStatus.AUTORIZADA,"0000000000","1111111111",users[0])
        )

        val movements = listOf(
            Movement(null, MovementType.INVENTARIO,"asd123", Instant.now(),users[0],collaborators[0],products,
                MovementStatus.PENDENTE,"Cambio de diretiva","111000002222")
        )

        collaboratorRepository.saveAll(collaborators)
        userRepository.saveAll(users)
        productRepository.saveAll(products)
        providerRepository.saveAll(providers)
        fiscalNoteRepository.saveAll(fiscalNotes)
        movementRepository.saveAll(movements)

        collaboratorRepository.flush()
        userRepository.flush()
        productRepository.flush()
        providerRepository.flush()
        fiscalNoteRepository.flush()
        movementRepository.flush()

    }
}