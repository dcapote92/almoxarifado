package com.angerbytes.almoxarifado.model

import com.angerbytes.almoxarifado.model.enums.MovementStatus
import com.angerbytes.almoxarifado.model.enums.MovementType

data class Movement(
    val type: MovementType,
    val docNumber: String,
    val dateTime: String,
    val user: User,
    val items: List<Product>,
    val totalValue: Double,
    var status: MovementStatus,
    val motive: String,
    val referenceDocument: String
)
