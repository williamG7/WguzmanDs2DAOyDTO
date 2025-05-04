package com.example.demo.persistence.dao.implementation

import com.example.demo.persistence.dao.interfaces.IUserDAO
import com.example.demo.persistence.entity.UserEntity
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
class UserDaoImpl : IUserDAO {

    @PersistenceContext
    private lateinit var em: EntityManager

    @Transactional
    override fun findAll(): List<UserEntity> {
        return em.createQuery("SELECT u FROM UserEntity u", UserEntity::class.java).resultList
    }

    @Transactional
    override fun findById(id: Long): Optional<UserEntity> {
        return Optional.ofNullable(em.find(UserEntity::class.java, id))
    }

    @Transactional
    override fun saveUser(userEntity: UserEntity) {
        em.persist(userEntity)
        em.flush()
    }

    @Transactional
    override fun updateUser(userEntity: UserEntity) {
        em.merge(userEntity)
        em.flush()
    }

    @Transactional
    override fun deleteUser(UserEntity: UserEntity) {
        em.remove(em.contains(UserEntity).let { if (it) UserEntity else em.merge(UserEntity) })
        em.flush()
    }
}
