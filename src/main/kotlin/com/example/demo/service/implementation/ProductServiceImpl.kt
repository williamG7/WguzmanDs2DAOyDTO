package com.example.demo.service.implementation

import com.example.demo.persistence.dao.interfaces.IProductDAO
import com.example.demo.presentation.dto.ProductDTO
import org.springframework.stereotype.Service
import com.example.demo.service.interfaces.IProductService

@Service
class ProductServiceImpl(
    private val productDao: IProductDAO
) : IProductService {

    override fun findAll(): List<ProductDTO> {
        return productDao.findAll().map { it.toDTO() }
    }

    override fun findById(id: Long): ProductDTO {
        val productEntity = productDao.findById(id)
            .orElseThrow { RuntimeException("Producto no encontrado") }
        return productEntity.toDTO()
    }

    override fun createProduct(productDTO: ProductDTO): ProductDTO {
        val productEntity = productDTO.toEntity()
        productDao.saveProduct(productEntity)
        return productEntity.toDTO()
    }

    override fun updateProduct(id: Long, productDTO: ProductDTO): ProductDTO {
        val productEntity = productDao.findById(id)
            .orElseThrow { IllegalArgumentException("Producto no encontrado") }

        productEntity.title = productDTO.title
        productEntity.actor = productDTO.actor
        productEntity.category = productDTO.category
        productEntity.price = productDTO.price
        productEntity.special = productDTO.special
        productEntity.commonProdId = productDTO.commonProdId

        productDao.updateProduct(productEntity)
        return productEntity.toDTO()
    }

    override fun deleteProduct(id: Long): String {
        val productEntity = productDao.findById(id)
            .orElseThrow { IllegalArgumentException("Producto no encontrado") }

        productDao.deleteProduct(productEntity)
        return "El producto con id $id fue eliminado"
    }
}
