package com.angerbytes.almoxarifado.model

import com.angerbytes.almoxarifado.model.enums.Sections
import jakarta.persistence.*

@Entity
@Table(name="tb_location")
data class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    var section: Sections?,
    var aisle: Char, // Corridor number
    var level: Byte, // shelf level
    var position: Byte // spot on the shelf
){
    constructor():this(null, Sections.OTHERS, 'A', 1, 1)
}
