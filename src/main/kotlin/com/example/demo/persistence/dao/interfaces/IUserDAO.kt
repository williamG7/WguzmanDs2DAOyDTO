package com.example.demo.persistence.dao.interfaces

import com.example.demo.persistence.entity.UserEntity
import java.util.Optional

interface IUserDAO {
    fun findAll(): List<UserEntity>

    fun findById(id: Long): Optional<UserEntity>

    fun saveUser(userEntity: UserEntity)

    fun updateUser(userEntity: UserEntity)

    fun deleteUser(UserEntity: UserEntity)
}