package com.angerbytes.almoxarifado.model.dto

import com.angerbytes.almoxarifado.model.FiscalNote
import com.angerbytes.almoxarifado.model.Product
import com.angerbytes.almoxarifado.model.Provider
import com.angerbytes.almoxarifado.model.enums.FiscalNoteStatus
import java.io.Serializable
import java.math.BigDecimal
import java.time.Instant

data class FiscalNoteDTO(
    val id: Long?,
    var keyAccess: String, // 44 characters ( Unique )
    var number: Int,
    var serie: String,
    var emitionDate: Instant?,
    var emitter: Provider?,
    var totalValue: BigDecimal?,
    var items: List<Product>?,
    var status: FiscalNoteStatus?,
    var xmlFile: String,
    var danfe: String,
    var registryUser: UserDTO
): Serializable{
    constructor(fiscalNote: FiscalNote):this(
        id = fiscalNote.id,
        keyAccess = fiscalNote.keyAccess,
        number = fiscalNote.number,
        serie = fiscalNote.serie,
        emitionDate = fiscalNote.emitionDate,
        emitter = fiscalNote.emitter,
        totalValue = fiscalNote.totalValue,
        items = fiscalNote.items,
        status = fiscalNote.status,
        xmlFile = fiscalNote.xmlFile,
        danfe = fiscalNote.danfe,
        registryUser = UserDTO(fiscalNote.registryUser)
    )
}
