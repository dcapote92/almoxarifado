package com.angerbytes.almoxarifado.model.dto

import com.angerbytes.almoxarifado.model.Product
import com.angerbytes.almoxarifado.model.enums.UnitMeasures
import java.io.Serializable

data class ProductDTO(
    val id: Long?,
    var name: String,
    var description: String,
    var category: String,
    var unitMeasure: UnitMeasures?,
    var price: String
): Serializable {
    constructor(product: Product):this(
        product.id,
        product.name,
        product.description,
        product.category,
        product.unitMeasure,
        "R$ ${product.price}"
    )
}
