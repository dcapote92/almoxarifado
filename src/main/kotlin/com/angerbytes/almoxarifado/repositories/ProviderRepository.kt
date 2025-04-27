package com.angerbytes.almoxarifado.repositories

import com.angerbytes.almoxarifado.model.Provider
import org.springframework.data.jpa.repository.JpaRepository


interface ProviderRepository: JpaRepository<Provider, Long>