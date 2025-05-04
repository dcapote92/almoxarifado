package com.angerbytes.almoxarifado.model.dto

import com.angerbytes.almoxarifado.model.User
import java.io.Serializable

data class UserDTO(
    val id: Long?,
    val login: String,
    val email: String,
    val collaborator: CollaboratorDTO
): Serializable{
    constructor(user: User): this(
        user.id,
        user.login,
        user.email,
        CollaboratorDTO(user.collaborator)
    )
}
