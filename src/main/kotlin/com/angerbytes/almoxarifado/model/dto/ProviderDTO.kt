package com.angerbytes.almoxarifado.model.dto

import com.angerbytes.almoxarifado.model.Provider
import java.io.Serializable

data class ProviderDTO(
    val id: Long?,
    var code: String?,
    var socialReason: String, // Complete legal name
    var fantasyName: String, // Comercial name
    var address: String, // CEP, street, number, complement, etc...
    var email: String,
    var personInCharge: String,
    var phone: String?
): Serializable{
    constructor(provider: Provider):this(
        provider.id,
        provider.code,
        provider.socialReason,
        provider.fantasyName,
        provider.address,
        provider.email,
        provider.personInCharge,
        provider.phone
    )
}
