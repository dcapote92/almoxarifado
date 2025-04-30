package com.angerbytes.almoxarifado.services

import com.angerbytes.almoxarifado.model.Location
import com.angerbytes.almoxarifado.repositories.LocationRepository
import com.angerbytes.almoxarifado.services.exceptions.DatabaseException
import com.angerbytes.almoxarifado.services.exceptions.ResourceNotFoundException
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class LocationService(@field:Autowired private val repository: LocationRepository) {

    fun findAll(): List<Location> =  repository.findAll()

    fun findById(id: Long): Location = repository.findById(id).orElseThrow {
        ResourceNotFoundException("Resource not found. Id: $id")
    }

    fun insert(location: Location) = repository.save(location)

    fun delete(id: Long){
        try {
            repository.deleteById(id)
        } catch (e: EmptyResultDataAccessException){
            throw ResourceNotFoundException(id)
        } catch (e: DataIntegrityViolationException){
            throw DatabaseException(e.message.toString())
        }

    }

    fun update(id: Long, location: Location): Location{
        try {
            val entity: Location = repository.getReferenceById(id)
            updateData(entity, location)
            return repository.save(entity)
        } catch (e: EntityNotFoundException){
            throw ResourceNotFoundException(id)
        }
    }

    fun updateData(entity: Location, location: Location){
        entity.section = location.section
        entity.aisle = location.aisle
        entity.level = location.level
        entity.position = location.position
    }


}