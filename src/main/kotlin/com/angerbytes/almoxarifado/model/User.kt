package com.angerbytes.almoxarifado.model

data class User(
    val id: Long,
    var name: String,
    var cpf: String,
    var email: String,
    var phone: String
)
