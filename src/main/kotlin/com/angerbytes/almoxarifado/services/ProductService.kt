package com.angerbytes.almoxarifado.services

import com.angerbytes.almoxarifado.model.Product
import com.angerbytes.almoxarifado.repositories.ProductRepository
import com.angerbytes.almoxarifado.services.exceptions.DatabaseException
import com.angerbytes.almoxarifado.services.exceptions.ResourceNotFoundException
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class ProductService(repository: ProductRepository) {

    @Autowired
    private val  repository: ProductRepository = repository

    fun findAll(): List<Product> =  repository.findAll()

    fun findById(id: Long): Product = repository.findById(id).orElseThrow {
        ResourceNotFoundException("Resource not found. Id: $id")
    }

    fun insert(product: Product) = repository.save(product)

    fun delete(id: Long){
        try {
            repository.deleteById(id)
        } catch (e: EmptyResultDataAccessException){
            throw ResourceNotFoundException(id)
        } catch (e: DataIntegrityViolationException){
            throw DatabaseException(e.message.toString())
        }

    }

    fun update(id: Long, product: Product): Product{
        try {
            val entity: Product = repository.getReferenceById(id)
            updateData(entity, product)
            return repository.save(entity)
        } catch (e: EntityNotFoundException){
            throw ResourceNotFoundException(id)
        }
    }

    fun updateData(entity: Product, product: Product){
        entity.name = product.name
        entity.uniqueCode = product.uniqueCode
        entity.barCode = product.barCode
        entity.category = product.category
        entity.description = product.description
        entity.unitMeasure = product.unitMeasure
    }


}