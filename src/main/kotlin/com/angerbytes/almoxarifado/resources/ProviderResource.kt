package com.angerbytes.almoxarifado.resources

import com.angerbytes.almoxarifado.model.Provider
import com.angerbytes.almoxarifado.services.ProviderService
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
@RequestMapping("/providers")
class ProviderResource(@field:Autowired val service: ProviderService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<Provider>>  {
        val list: List<Provider> = service.findAll()
        return ResponseEntity.ok().body(list)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Provider>{
        val provider: Provider = service.findById(id)
        return ResponseEntity.ok().body(provider)
    }

    @PostMapping
    fun insert(@RequestBody provider: Provider): ResponseEntity<Provider>{
        val provider = service.insert(provider)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
            .buildAndExpand(provider.id).toUri()
        return ResponseEntity.created(uri).body(provider)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any>{
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody provider: Provider): ResponseEntity<Provider>{
        val provider = service.update(id, provider)
        return ResponseEntity.ok().body(provider)
    }

}