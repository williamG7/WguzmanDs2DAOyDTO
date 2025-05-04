package com.example.demo.service.interfaces

import com.example.demo.presentation.dto.ProductDTO

interface IProductService {
    fun findAll(): List<ProductDTO>
    fun findById(id: Long): ProductDTO
    fun createProduct(productDTO: ProductDTO): ProductDTO
    fun updateProduct(id: Long, productDTO: ProductDTO): ProductDTO
    fun deleteProduct(id: Long): String
}