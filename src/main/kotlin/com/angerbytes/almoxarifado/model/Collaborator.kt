package com.angerbytes.almoxarifado.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="tb_collaborator")
data class Collaborator(
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    val id: Long?,
    var name: String,
    var cpf: String,
    var registration: String,
    var jobPosition: String
){
    constructor():this(
        null,
        "",
        "",
        "",
        ""
    )
}
