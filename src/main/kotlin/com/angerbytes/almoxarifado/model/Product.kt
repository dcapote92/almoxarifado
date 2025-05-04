package com.angerbytes.almoxarifado.model

import com.angerbytes.almoxarifado.model.enums.UnitMeasures
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name="tb_product")
data class Product(
    // Identification
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    var uniqueCode: String,
    var barCode: String,
    var name: String,
    var description: String,
    var category: String,

    // Stock
    var stockQuantity: BigDecimal,
    var minStock: BigDecimal,
    var maxStock: BigDecimal,
    @Embedded
    var location: Location,

    // Manufacture & Expiration Dates
    var manufactureDate: Instant?,
    var expirationDate: Instant?,

    // Relations
    @ManyToOne
    var mainProvider: Provider,
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    var alternativeProviders: List<Provider>,

    // Measures
    var unitWeight: BigDecimal,
    var UnitVolume: BigDecimal,
    var unitMeasure: UnitMeasures?,


    var unitPrice: BigDecimal,
    var active: Boolean
    ){
    constructor(): this(
        null,
        "",
        "",
        "",
        "",
        "",
        BigDecimal.ZERO,
        BigDecimal.ZERO,
        BigDecimal.ZERO,
        Location(),
        Instant.now(),
        Instant.now(),
        Provider(),
        listOf<Provider>(),
        BigDecimal.ZERO,
        BigDecimal.ZERO,
        UnitMeasures.UNIDADE,
        BigDecimal.ZERO,
        true
    )
}
