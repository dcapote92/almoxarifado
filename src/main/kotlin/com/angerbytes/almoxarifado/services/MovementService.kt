package com.angerbytes.almoxarifado.services

import com.angerbytes.almoxarifado.model.Movement
import com.angerbytes.almoxarifado.repositories.MovementRepository
import com.angerbytes.almoxarifado.services.exceptions.DatabaseException
import com.angerbytes.almoxarifado.services.exceptions.ResourceNotFoundException
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class MovementService(@field:Autowired private val repository: MovementRepository) {

    fun findAll(): List<Movement> =  repository.findAll()

    fun findById(id: Long): Movement = repository.findById(id).orElseThrow {
        ResourceNotFoundException("Resource not found. Id: $id")
    }

    fun insert(movement: Movement) = repository.save(movement)

    fun delete(id: Long){
        try {
            repository.deleteById(id)
        } catch (e: EmptyResultDataAccessException){
            throw ResourceNotFoundException(id)
        } catch (e: DataIntegrityViolationException){
            throw DatabaseException(e.message.toString())
        }

    }

    fun update(id: Long, movement: Movement): Movement{
        try {
            val entity: Movement = repository.getReferenceById(id)
            updateData(entity, movement)
            return repository.save(entity)
        } catch (e: EntityNotFoundException){
            throw ResourceNotFoundException(id)
        }
    }

    fun updateData(entity: Movement, movement: Movement){
        entity.type = movement.type
        entity.status = movement.status
        entity.items = movement.items
        entity.motive = movement.motive
        entity.user = movement.user
        entity.collaborator= movement.collaborator
        entity.docNumber = movement.docNumber
        entity.referenceDocument = movement.referenceDocument
        entity.dateTime = movement.dateTime
    }


}