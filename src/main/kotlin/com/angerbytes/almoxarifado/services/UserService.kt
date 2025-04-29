package com.angerbytes.almoxarifado.services

import com.angerbytes.almoxarifado.model.User
import com.angerbytes.almoxarifado.repositories.UserRepository
import com.angerbytes.almoxarifado.services.exceptions.DatabaseException
import com.angerbytes.almoxarifado.services.exceptions.ResourceNotFoundException
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class UserService(@field:Autowired private val repository: UserRepository) {

    fun findAll(): List<User> =  repository.findAll()

    fun findById(id: Long): User = repository.findById(id).orElseThrow {
        ResourceNotFoundException("Resource not found. Id: $id")
    }

    fun insert(user: User) = repository.save(user)

    fun delete(id: Long){
        try {
            repository.deleteById(id)
        } catch (e: EmptyResultDataAccessException){
            throw ResourceNotFoundException(id)
        } catch (e: DataIntegrityViolationException){
            throw DatabaseException(e.message.toString())
        }

    }

    fun update(id: Long, user: User): User{
        try {
            val entity: User = repository.getReferenceById(id)
            updateData(entity, user)
            return repository.save(entity)
        } catch (e: EntityNotFoundException){
            throw ResourceNotFoundException(id)
        }
    }

    fun updateData(entity: User, user: User){
        entity.name = user.name
        entity.cpf = user.cpf
        entity.email = user.email
        entity.phone = user.phone
    }


}