package com.angerbytes.almoxarifado.model

import com.angerbytes.almoxarifado.model.enums.MovementStatus
import com.angerbytes.almoxarifado.model.enums.MovementType
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name="tb_movement")
data class Movement(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    var type: MovementType,
    var docNumber: String,
    var dateTime: Instant,
    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User,
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    var items: List<Product>,
    var totalValue: BigDecimal,
    var status: MovementStatus,
    var motive: String,
    var referenceDocument: String
){
    constructor():this(
        null,
        MovementType.INVENTARIO,
        "",
        Instant.now(),
        User(),
        listOf(),
        BigDecimal("0.0"),
        MovementStatus.PENDENTE,
        "",
        ""
    )
}
