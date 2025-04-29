package com.angerbytes.almoxarifado.services

import com.angerbytes.almoxarifado.model.FiscalNote
import com.angerbytes.almoxarifado.repositories.FiscalNoteRepository
import com.angerbytes.almoxarifado.services.exceptions.DatabaseException
import com.angerbytes.almoxarifado.services.exceptions.ResourceNotFoundException
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class FiscalNoteService(@field:Autowired private val repository: FiscalNoteRepository) {

    fun findAll(): List<FiscalNote> =  repository.findAll()

    fun findById(id: Long): FiscalNote = repository.findById(id).orElseThrow {
        ResourceNotFoundException("Resource not found. Id: $id")
    }

    fun insert(fiscalNote: FiscalNote) = repository.save(fiscalNote)

    fun delete(id: Long){
        try {
            repository.deleteById(id)
        } catch (e: EmptyResultDataAccessException){
            throw ResourceNotFoundException(id)
        } catch (e: DataIntegrityViolationException){
            throw DatabaseException(e.message.toString())
        }

    }

    fun update(id: Long, fiscalNote: FiscalNote): FiscalNote{
        try {
            val entity: FiscalNote = repository.getReferenceById(id)
            updateData(entity, fiscalNote)
            return repository.save(entity)
        } catch (e: EntityNotFoundException){
            throw ResourceNotFoundException(id)
        }
    }

    fun updateData(entity: FiscalNote, fiscalNote: FiscalNote){
        entity.keyAccess = fiscalNote.keyAccess
        entity.model = fiscalNote.model
        entity.serie = fiscalNote.serie
        entity.number = fiscalNote.number
        entity.status = fiscalNote.status
        entity.items = fiscalNote.items
        entity.emitter = fiscalNote.emitter
        entity.emitionDate = fiscalNote.emitionDate
        entity.entryDate = fiscalNote.entryDate
        entity.registryUser = fiscalNote.registryUser
        entity.productsValue = fiscalNote.productsValue
        entity.ensureValue = fiscalNote.ensureValue
        entity.transportationValue = fiscalNote.transportationValue
        entity.discontValue = fiscalNote.discontValue
        entity.totalValue = fiscalNote.totalValue
        entity.danfe = fiscalNote.danfe
        entity.xmlFile = fiscalNote.xmlFile

    }


}