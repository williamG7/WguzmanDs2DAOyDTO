package com.example.demo.persistence.dao.interfaces

import com.example.demo.persistence.entity.ProductEntity
import java.util.Optional

interface IProductDAO {
    fun findAll(): List<ProductEntity>

    fun findById(id: Long): Optional<ProductEntity>

    fun saveProduct(productEntity: ProductEntity)

    fun updateProduct(productEntity: ProductEntity)

    fun deleteProduct(productEntity: ProductEntity)
}
