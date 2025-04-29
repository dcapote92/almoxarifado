package com.angerbytes.almoxarifado.resources

import com.angerbytes.almoxarifado.model.FiscalNote
import com.angerbytes.almoxarifado.services.FiscalNoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/fiscalnotes")
class FiscalNoteResource(@field:Autowired val service: FiscalNoteService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<FiscalNote>>  {
        val list: List<FiscalNote> = service.findAll()
        return ResponseEntity.ok().body(list)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<FiscalNote>{
        val fiscalNote: FiscalNote = service.findById(id)
        return ResponseEntity.ok().body(fiscalNote)
    }

    @PostMapping
    fun insert(@RequestBody fiscalNote: FiscalNote): ResponseEntity<FiscalNote>{
        val fiscalNote = service.insert(fiscalNote)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
            .buildAndExpand(fiscalNote.id).toUri()
        return ResponseEntity.created(uri).body(fiscalNote)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any>{
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody fiscalNote: FiscalNote): ResponseEntity<FiscalNote>{
        val fiscalNote = service.update(id, fiscalNote)
        return ResponseEntity.ok().body(fiscalNote)
    }

}