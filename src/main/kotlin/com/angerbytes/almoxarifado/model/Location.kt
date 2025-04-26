package com.angerbytes.almoxarifado.model

import com.angerbytes.almoxarifado.model.enums.Priority

data class Location(
    val code: String,
    val type: String,
    val zone: String,
    val capacity: Double,
    val blocked: Boolean,
    val priority: Priority
)
