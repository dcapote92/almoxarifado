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
    val type: MovementType,
    val docNumber: String,
    val dateTime: Instant,
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    val items: List<Product>,
    val totalValue: BigDecimal,
    var status: MovementStatus,
    val motive: String,
    val referenceDocument: String
)
