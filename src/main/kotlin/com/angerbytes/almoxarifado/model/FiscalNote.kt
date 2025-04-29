package com.angerbytes.almoxarifado.model

import com.angerbytes.almoxarifado.model.enums.FiscalNoteModel
import com.angerbytes.almoxarifado.model.enums.FiscalNoteStatus
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name="tb_nf")
data class FiscalNote(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(length = 44, unique = true)
    var keyAccess: String, // 44 characters ( Unique )
    @Column(nullable = false)
    var number: String,
    @Column(nullable = false)
    var serie: String,
    var model: FiscalNoteModel, // 55 for NFe, 65 for NFCe
    var emitionDate: String,
    var entryDate: String,
    @ManyToOne
    var emitter: Provider?,
    var totalValue: BigDecimal?,
    var productsValue: BigDecimal?,
    var discontValue: BigDecimal?,
    var transportationValue: BigDecimal?,
    var ensureValue: BigDecimal?,
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    var items: List<Product>?,
    @Enumerated(EnumType.STRING)
    var status: FiscalNoteStatus?,
    @Lob
    var xmlFile: String,
    @Lob
    var danfe: String,
    @ManyToOne
    var registryUser: User?
){
    constructor():this(null,"","","", FiscalNoteModel.NFE,"",
        "",null,null,null,null,
        null,null,null,null,"","",
        null)

}
