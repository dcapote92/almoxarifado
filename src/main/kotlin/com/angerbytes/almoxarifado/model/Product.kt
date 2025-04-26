package com.angerbytes.almoxarifado.model

data class Product(
    val uniqueCode: String,
    val barCode: String,
    val name: String,
    val description: String,
    val category: String,
    val unitMeasure: String
    )
