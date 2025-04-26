package com.angerbytes.almoxarifado.repositories

import com.angerbytes.almoxarifado.model.User
import org.springframework.data.jpa.repository.JpaRepository


interface UserRepository: JpaRepository<User, Long>