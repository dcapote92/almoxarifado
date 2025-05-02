package com.angerbytes.almoxarifado.resources

import com.angerbytes.almoxarifado.model.User
import com.angerbytes.almoxarifado.model.dto.UserDTO
import com.angerbytes.almoxarifado.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/users")
class UserResource(@field:Autowired val service: UserService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<UserDTO>>  {
        val list: List<User> = service.findAll()
        val listDTO: List<UserDTO> = list.map(::UserDTO)
        return ResponseEntity.ok().body(listDTO.toList())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<User>{
        val user: User = service.findById(id)
        return ResponseEntity.ok().body(user)
    }

    @PostMapping
    fun insert(@RequestBody user: User): ResponseEntity<User>{
        val user = service.insert(user)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
            .buildAndExpand(user.id).toUri()
        return ResponseEntity.created(uri).body(user)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any>{
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody user: User): ResponseEntity<User>{
        val user = service.update(id, user)
        return ResponseEntity.ok().body(user)
    }

}