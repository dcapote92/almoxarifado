package com.angerbytes.almoxarifado.services

import com.angerbytes.almoxarifado.model.Collaborator
import com.angerbytes.almoxarifado.repositories.CollaboratorRepository
import com.angerbytes.almoxarifado.services.exceptions.DatabaseException
import com.angerbytes.almoxarifado.services.exceptions.ResourceNotFoundException
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class CollaboratorService(@field:Autowired private val repository: CollaboratorRepository) {

    fun findAll(): List<Collaborator> =  repository.findAll()

    fun findById(id: Long): Collaborator = repository.findById(id).orElseThrow {
        ResourceNotFoundException("Resource not found. Id: $id")
    }

    fun insert(collaborator: Collaborator) = repository.save(collaborator)

    fun delete(id: Long){
        try {
            repository.deleteById(id)
        } catch (e: EmptyResultDataAccessException){
            throw ResourceNotFoundException(id)
        } catch (e: DataIntegrityViolationException){
            throw DatabaseException(e.message.toString())
        }

    }

    fun update(id: Long, collaborator: Collaborator): Collaborator{
        try {
            val entity: Collaborator = repository.getReferenceById(id)
            updateData(entity, collaborator)
            return repository.save(entity)
        } catch (e: EntityNotFoundException){
            throw ResourceNotFoundException(id)
        }
    }

    fun updateData(entity: Collaborator, collaborator: Collaborator){
        entity.cpf = collaborator.cpf
        entity.name = collaborator.name
        entity.registration = collaborator.registration
        entity.jobPosition = collaborator.jobPosition
    }


}