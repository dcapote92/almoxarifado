package com.angerbytes.almoxarifado.resources

import com.angerbytes.almoxarifado.model.Collaborator
import com.angerbytes.almoxarifado.model.dto.CollaboratorDTO
import com.angerbytes.almoxarifado.services.CollaboratorService
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
@RequestMapping("/collaborators")
class CollaboratorResource(@field:Autowired val service: CollaboratorService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<CollaboratorDTO>>  {
        val list: List<Collaborator> = service.findAll()
        val listDTO: List<CollaboratorDTO> = list.map(::CollaboratorDTO)
        return ResponseEntity.ok().body(listDTO.toList())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Collaborator>{
        val collaborator: Collaborator = service.findById(id)
        return ResponseEntity.ok().body(collaborator)
    }

    @PostMapping
    fun insert(@RequestBody collaborator: Collaborator): ResponseEntity<Collaborator>{
        val collaborator = service.insert(collaborator)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
            .buildAndExpand(collaborator.id).toUri()
        return ResponseEntity.created(uri).body(collaborator)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any>{
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody collaborator: Collaborator): ResponseEntity<Collaborator>{
        val collaborator = service.update(id, collaborator)
        return ResponseEntity.ok().body(collaborator)
    }

}