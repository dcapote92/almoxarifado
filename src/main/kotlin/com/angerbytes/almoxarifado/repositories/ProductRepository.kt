package com.angerbytes.almoxarifado.repositories

import com.angerbytes.almoxarifado.model.Product
import org.springframework.data.jpa.repository.JpaRepository


interface ProductRepository: JpaRepository<Product, Long>