package com.angerbytes.almoxarifado.services

import com.angerbytes.almoxarifado.model.User
import com.angerbytes.almoxarifado.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class UserService(repository: UserRepository) {

    @Autowired
    private val  repository: UserRepository = repository

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
            throw DatabaseException(e.message)
        }
    }


}