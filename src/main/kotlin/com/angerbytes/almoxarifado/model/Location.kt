package com.angerbytes.almoxarifado.model

import com.angerbytes.almoxarifado.model.enums.Sections
import jakarta.persistence.*


@Embeddable
data class Location(
    var section: Sections?,
    var aisle: Char, // Corridor number
    var level: Byte, // shelf level
    var position: Byte // spot on the shelf
){
    constructor():this(
        Sections.OUTROS,
        'A',
        1,
        1
    )
}
