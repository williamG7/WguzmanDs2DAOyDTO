package com.example.demo.presentation.controller

import com.example.demo.presentation.dto.ProductDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.example.demo.service.interfaces.IProductService

@RestController
@RequestMapping("/api/v1/products")
class ProductController(
    private val productService: IProductService
) {

    @GetMapping("/find")
    fun findAll(): ResponseEntity<List<ProductDTO>> {
        val products = productService.findAll()
        return ResponseEntity.ok(products)
    }

    @GetMapping("/find/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<ProductDTO> {
        val product = productService.findById(id)
        return ResponseEntity.ok(product)
    }

    @PostMapping("/create")
    fun createProduct(@RequestBody productDTO: ProductDTO): ResponseEntity<ProductDTO> {
        val createdProduct = productService.createProduct(productDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct)
    }

    @PutMapping("/update/{id}")
    fun updateProduct(@PathVariable id: Long, @RequestBody productDTO: ProductDTO): ResponseEntity<ProductDTO> {
        val updatedProduct = productService.updateProduct(id, productDTO)
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteProduct(@PathVariable id: Long): ResponseEntity<String> {
        val message = productService.deleteProduct(id)
        return ResponseEntity.ok(message)
    }
}
