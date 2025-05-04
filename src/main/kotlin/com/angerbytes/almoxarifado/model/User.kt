package com.angerbytes.almoxarifado.model

import jakarta.persistence.*

@Entity
@Table(name = "tb_user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @OneToOne()
    @JoinColumn(name = "collaborator_id")
    var collaborator: Collaborator,
    var email: String,
    var phone: String,
    var login: String,
    var password: String
){
    constructor(): this(
        null,
        Collaborator(),
        "",
        "",
        "",
        "",
    )
}

