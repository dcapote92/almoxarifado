package com.angerbytes.almoxarifado.model.dto

import com.angerbytes.almoxarifado.model.FiscalNote
import com.angerbytes.almoxarifado.model.Product
import com.angerbytes.almoxarifado.model.Provider
import com.angerbytes.almoxarifado.model.enums.FiscalNoteStatus
import java.io.Serializable
import java.time.Instant

data class FiscalNoteDTO(
    val id: Long?,
    var keyAccess: String, // 44 characters ( Unique )
    var number: Int,
    var serie: String,
    var emitionDate: Instant?,
    var emitter: Provider?,
    var totalValue: String,
    var items: List<Product>?,
    var status: FiscalNoteStatus?,
    var xmlFile: String,
    var danfe: String,
    var registryUser: UserDTO
): Serializable{
    constructor(fiscalNote: FiscalNote):this(
        fiscalNote.id,
        fiscalNote.keyAccess,
        fiscalNote.number,
        fiscalNote.serie,
        fiscalNote.emitionDate,
        fiscalNote.emitter,
        "R$ ${fiscalNote.totalValue}",
        fiscalNote.items,
        fiscalNote.status,
        fiscalNote.xmlFile,
        fiscalNote.danfe,
        UserDTO(fiscalNote.registryUser)
    )
}
