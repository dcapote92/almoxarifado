package com.angerbytes.almoxarifado.model

data class User(
    val id: Long,
    val name: String,
    val cpf: String,
    val email: String,
    val phone: String
)
