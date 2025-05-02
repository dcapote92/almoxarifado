package com.angerbytes.almoxarifado.model.dto

import com.angerbytes.almoxarifado.model.User
import java.io.Serializable

data class UserDTO(
    val id: Long?,
    val name: String,
    val login: String,
    val email: String
): Serializable{
    constructor(user: User): this(
        id = user.id,
        name = user.name,
        login = user.login,
        email = user.email
    )
}
