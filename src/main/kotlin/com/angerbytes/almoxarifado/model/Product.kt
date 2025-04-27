package com.angerbytes.almoxarifado.model

import jakarta.persistence.*

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
    var unitMeasure: String
    ){
    constructor(): this(null,"","","","","","")
}
