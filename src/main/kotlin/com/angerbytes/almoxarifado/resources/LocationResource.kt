package com.angerbytes.almoxarifado.resources

import com.angerbytes.almoxarifado.model.Location
import com.angerbytes.almoxarifado.services.LocationService
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
@RequestMapping("/locations")
class LocationResource(@field:Autowired val service: LocationService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<Location>>  {
        val list: List<Location> = service.findAll()
        return ResponseEntity.ok().body(list)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Location>{
        val location: Location = service.findById(id)
        return ResponseEntity.ok().body(location)
    }

    @PostMapping
    fun insert(@RequestBody location: Location): ResponseEntity<Location>{
        val location = service.insert(location)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
            .buildAndExpand(location.id).toUri()
        return ResponseEntity.created(uri).body(location)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any>{
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody location: Location): ResponseEntity<Location>{
        val location = service.update(id, location)
        return ResponseEntity.ok().body(location)
    }

}