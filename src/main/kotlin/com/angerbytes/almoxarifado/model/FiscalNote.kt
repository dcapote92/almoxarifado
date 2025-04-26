package com.angerbytes.almoxarifado.model

import com.angerbytes.almoxarifado.model.enums.FiscalNoteStatus

data class FiscalNote(
    val keyAccess: String, // 44 characters ( Unique )
    val number: String,
    val serie: String,
    val model: Byte, // 55 for NFe, 65 for NFCe
    val emitionDate: String,
    val entryDate: String,
    val emitter: Provider,
    val totalValue: Double,
    val productsValue: Double,
    val discontValue: Double,
    val transportationValue: Double,
    val ensureValue: Double,
    val items: List<Product>,
    var status: FiscalNoteStatus,
    val xmlFile: String,
    val danfe: String,
    val registryUser: User
)
