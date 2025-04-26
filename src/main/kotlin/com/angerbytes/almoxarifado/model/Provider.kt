package com.angerbytes.almoxarifado.model

data class Provider(
    val code: String,
    val type: String, // Physic/Juridic person (CPF/CNPJ)
    val document: String, // CNPJ for the NFe - 14 digits
    val IE: String, // State Inscription
    val socialReason: String, // Complete legal name
    val fantasyName: String, // Comercial name
    val address: String, // CEP, street, number, complement, etc...
    val email: String,
    val personInCharge: String,
    val telefone: String?
)
