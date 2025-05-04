package com.angerbytes.almoxarifado.model.dto

import com.angerbytes.almoxarifado.model.Product
import com.angerbytes.almoxarifado.model.Provider
import java.io.Serializable
import java.math.BigDecimal
import java.time.Instant

data class ProductDTO(
    val id: Long?,
    var name: String,
    var description: String,
    var category: String,
    var stockQuantity: BigDecimal,
    var manufactureDate: Instant?,
    var expirationDate: Instant?,
    var mainProvider: Provider,
    var price: String,
    var active: Boolean
): Serializable {
    constructor(product: Product):this(
        product.id,
        product.name,
        product.description,
        product.category,
        product.stockQuantity,
        product.manufactureDate,
        product.expirationDate,
        product.mainProvider,
        "R$ ${product.unitPrice}",
        product.active
    )
}
