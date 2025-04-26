package com.angerbytes.almoxarifado.resources.exceptions

import com.angerbytes.almoxarifado.services.exceptions.DatabaseException
import com.angerbytes.almoxarifado.services.exceptions.ResourceNotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.Instant

@ControllerAdvice
class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFound( e: ResourceNotFoundException, request: HttpServletRequest): ResponseEntity<StandardError>{
        val msg: String = "Resource not found"
        val status: HttpStatus = HttpStatus.NOT_FOUND
        val error = StandardError(Instant.now(),
            status.value(),
            msg,
            e.message.toString(),
            request.requestURI)
        return ResponseEntity.status(status).body(error)
    }

    @ExceptionHandler(DatabaseException::class)
    fun databaseError( e: DatabaseException, request: HttpServletRequest): ResponseEntity<StandardError>{
        val msg: String = "Database Error"
        val status: HttpStatus = HttpStatus.BAD_REQUEST
        val error = StandardError(Instant.now(),
            status.value(),
            msg,
            e.message.toString(),
            request.requestURI)
        return ResponseEntity.status(status).body(error)
    }


}