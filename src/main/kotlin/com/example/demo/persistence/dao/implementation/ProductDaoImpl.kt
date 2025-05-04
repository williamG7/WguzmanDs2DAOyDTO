package com.example.demo.persistence.dao.implementation

import com.example.demo.persistence.dao.interfaces.IProductDAO
import com.example.demo.persistence.entity.ProductEntity
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
class ProductDaoImpl : IProductDAO {

    @PersistenceContext
    private lateinit var em: EntityManager

    @Transactional
    override fun findAll(): List<ProductEntity> {
        return em.createQuery("SELECT p FROM ProductEntity p", ProductEntity::class.java).resultList
    }

    @Transactional
    override fun findById(id: Long): Optional<ProductEntity> {
        return Optional.ofNullable(em.find(ProductEntity::class.java, id))
    }

    @Transactional
    override fun saveProduct(productEntity: ProductEntity) {
        em.persist(productEntity)
        em.flush()
    }

    @Transactional
    override fun updateProduct(productEntity: ProductEntity) {
        em.merge(productEntity)
        em.flush()
    }

    @Transactional
    override fun deleteProduct(productEntity: ProductEntity) {
        em.remove(if (em.contains(productEntity)) productEntity else em.merge(productEntity))
        em.flush()
    }
}
