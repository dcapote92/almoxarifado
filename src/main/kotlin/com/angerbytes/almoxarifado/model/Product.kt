package com.angerbytes.almoxarifado.model

import com.angerbytes.almoxarifado.model.enums.UnitMeasures
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name="tb_product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    var uniqueCode: String,
    var barCode: String,
    var name: String,
    var description: String,
    var category: String,
    var unitMeasure: UnitMeasures?,
    var price: BigDecimal
    ){
    constructor(): this(
        null,
        "",
        "",
        "",
        "",
        "",
        UnitMeasures.UNIDADE,
        BigDecimal("0.0")
    )
}
