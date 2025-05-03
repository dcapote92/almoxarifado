package com.angerbytes.almoxarifado.services

import com.angerbytes.almoxarifado.model.Provider
import com.angerbytes.almoxarifado.repositories.ProviderRepository
import com.angerbytes.almoxarifado.services.exceptions.DatabaseException
import com.angerbytes.almoxarifado.services.exceptions.ResourceNotFoundException
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class ProviderService(@field:Autowired private val repository: ProviderRepository) {

    fun findAll(): List<Provider> =  repository.findAll()

    fun findById(id: Long): Provider = repository.findById(id).orElseThrow {
        ResourceNotFoundException("Resource not found. Id: $id")
    }

    fun insert(provider: Provider) = repository.save(provider)

    fun delete(id: Long){
        try {
            repository.deleteById(id)
        } catch (e: EmptyResultDataAccessException){
            throw ResourceNotFoundException(id)
        } catch (e: DataIntegrityViolationException){
            throw DatabaseException(e.message.toString())
        }

    }

    fun update(id: Long, provider: Provider): Provider{
        try {
            val entity: Provider = repository.getReferenceById(id)
            updateData(entity, provider)
            return repository.save(entity)
        } catch (e: EntityNotFoundException){
            throw ResourceNotFoundException(id)
        }
    }

    fun updateData(entity: Provider, provider: Provider){
        entity.code = provider.code
        entity.socialReason = provider.socialReason
        entity.fantasyName = provider.fantasyName
        entity.IE = provider.IE
        entity.type = provider.type
        entity.document = provider.document
        entity.address = provider.address
        entity.email = provider.email
        entity.phone = provider.phone
        entity.personInCharge = provider.personInCharge
    }


}