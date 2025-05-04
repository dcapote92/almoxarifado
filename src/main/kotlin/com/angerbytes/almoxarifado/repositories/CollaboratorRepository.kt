package com.angerbytes.almoxarifado.repositories

import com.angerbytes.almoxarifado.model.Collaborator
import org.springframework.data.jpa.repository.JpaRepository


interface CollaboratorRepository: JpaRepository<Collaborator, Long>