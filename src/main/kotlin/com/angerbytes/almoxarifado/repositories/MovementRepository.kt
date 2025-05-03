package com.angerbytes.almoxarifado.repositories

import com.angerbytes.almoxarifado.model.Movement
import org.springframework.data.jpa.repository.JpaRepository


interface MovementRepository: JpaRepository<Movement, Long>