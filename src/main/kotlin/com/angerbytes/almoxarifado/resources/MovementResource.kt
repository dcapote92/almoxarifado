package com.angerbytes.almoxarifado.resources

import com.angerbytes.almoxarifado.model.Movement
import com.angerbytes.almoxarifado.model.dto.MovementDTO
import com.angerbytes.almoxarifado.services.MovementService
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
@RequestMapping("/movements")
class MovementResource(@field:Autowired val service: MovementService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<MovementDTO>>  {
        val list: List<Movement> = service.findAll()
        val listDTO: List<MovementDTO> = list.map(::MovementDTO)
        return ResponseEntity.ok().body(listDTO.toList())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Movement>{
        val movement: Movement = service.findById(id)
        return ResponseEntity.ok().body(movement)
    }

    @PostMapping
    fun insert(@RequestBody movement: Movement): ResponseEntity<Movement>{
        val movement = service.insert(movement)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
            .buildAndExpand(movement.id).toUri()
        return ResponseEntity.created(uri).body(movement)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any>{
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody movement: Movement): ResponseEntity<Movement>{
        val movement = service.update(id, movement)
        return ResponseEntity.ok().body(movement)
    }

}