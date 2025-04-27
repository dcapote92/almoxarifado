package com.angerbytes.almoxarifado.resources

import com.angerbytes.almoxarifado.model.Product
import com.angerbytes.almoxarifado.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/products")
class ProductResource(service: ProductService) {

    @Autowired
    val service: ProductService = service

    @GetMapping
    fun findAll(): ResponseEntity<List<Product>>  {
        val list: List<Product> = service.findAll()
        return ResponseEntity.ok().body(list)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Product>{
        val product: Product = service.findById(id)
        return ResponseEntity.ok().body(product)
    }

    @PostMapping
    fun insert(@RequestBody product: Product): ResponseEntity<Product>{
        val product = service.insert(product)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
            .buildAndExpand(product.id).toUri()
        return ResponseEntity.created(uri).body(product)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any>{
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody product: Product): ResponseEntity<Product>{
        val product = service.update(id, product)
        return ResponseEntity.ok().body(product)
    }

}