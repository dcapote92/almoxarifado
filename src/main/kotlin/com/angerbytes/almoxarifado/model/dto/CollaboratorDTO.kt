package com.angerbytes.almoxarifado.model.dto

import com.angerbytes.almoxarifado.model.Collaborator
import java.io.Serializable

data class CollaboratorDTO(
    val id: Long?,
    val name: String,
    val registration: String,
    val jobPosition: String
): Serializable {
    constructor(collaborator: Collaborator?):this(
        collaborator?.id,
        collaborator?.name ?:"",
        collaborator?.registration ?:"",
        collaborator?.jobPosition ?:"",
    )
}
