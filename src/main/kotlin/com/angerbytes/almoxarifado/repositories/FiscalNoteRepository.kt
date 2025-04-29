package com.angerbytes.almoxarifado.repositories

import com.angerbytes.almoxarifado.model.FiscalNote
import org.springframework.data.jpa.repository.JpaRepository


interface FiscalNoteRepository: JpaRepository<FiscalNote, Long>