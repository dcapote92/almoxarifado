package com.angerbytes.almoxarifado.model

import com.angerbytes.almoxarifado.model.enums.ProviderType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name="tb_provider")
data class Provider(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    var code: String,
    @Enumerated(EnumType.STRING)
    var type: ProviderType, // Physic/Juridic person (CPF/CNPJ)
    @Column(length = 18, unique = true)
    var document: String, // CNPJ for the NFe - 14 digits
    var IE: String, // State Inscription
    var socialReason: String, // Complete legal name
    var fantasyName: String, // Comercial name
    var address: String, // CEP, street, number, complement, etc...
    var email: String,
    var personInCharge: String,
    var phone: String?
){
    constructor():this(
        null,
        "",
        ProviderType.PESSOA_JURIDICA,
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    )
}
