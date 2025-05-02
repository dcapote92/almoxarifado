package com.angerbytes.almoxarifado.model

import jakarta.persistence.*

@Entity
@Table(name = "tb_user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    var name: String,
    var cpf: String,
    var email: String,
    var phone: String,
    var login: String,
    var password: String
){
    constructor(): this(null,"","","","","","")
}

