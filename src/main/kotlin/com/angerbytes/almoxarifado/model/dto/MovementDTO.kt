package com.angerbytes.almoxarifado.model.dto

import com.angerbytes.almoxarifado.model.Movement
import com.angerbytes.almoxarifado.model.Product
import com.angerbytes.almoxarifado.model.enums.MovementStatus
import com.angerbytes.almoxarifado.model.enums.MovementType
import java.io.Serializable
import java.time.Instant

data class MovementDTO(
    val id: Long?,
    val type: MovementType,
    val dateTime: Instant,
    val user: UserDTO,
    val items: List<Product>,
    val totalValue: String,
    var status: MovementStatus,
): Serializable {
    constructor(movement: Movement):this(
        movement.id,
        movement.type,
        movement.dateTime,
        UserDTO(movement.user),
        movement.items,
        "R$ ${movement.totalValue}",
        movement.status
    )
}
