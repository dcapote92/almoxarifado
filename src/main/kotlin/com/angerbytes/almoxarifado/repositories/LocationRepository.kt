package com.angerbytes.almoxarifado.repositories

import com.angerbytes.almoxarifado.model.Location
import org.springframework.data.jpa.repository.JpaRepository


interface LocationRepository: JpaRepository<Location, Long>