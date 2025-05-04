package com.example.demo.service.implementation

import com.example.demo.persistence.dao.interfaces.IUserDAO
import com.example.demo.presentation.dto.UserDTO
import org.springframework.stereotype.Service
import com.example.demo.service.interfaces.IUserService

@Service
class UserServiceImpl(
    private val userDao: IUserDAO
) : IUserService {

    override fun findAll(): List<UserDTO> {
        return userDao.findAll().map { it.toDTO() }
    }

    override fun findById(id: Long): UserDTO {
        val userEntity = userDao.findById(id)
            .orElseThrow { RuntimeException("Usuario no encontrado") }
        return userEntity.toDTO()
    }

    override fun createUser(userDTO: UserDTO): UserDTO {
        val userEntity = userDTO.toEntity()
        userDao.saveUser(userEntity)
        return userEntity.toDTO()
    }

    override fun updateUser(id: Long, userDTO: UserDTO): UserDTO {
        val userEntity = userDao.findById(id)
            .orElseThrow { IllegalArgumentException("Usuario no encontrado") }

        userEntity.name = userDTO.name
        userEntity.lastName = userDTO.lastName
        userEntity.email = userDTO.email
        userEntity.age = userDTO.age

        userDao.updateUser(userEntity)
        return userEntity.toDTO()
    }

    override fun deleteUser(id: Long): String {
        val userEntity = userDao.findById(id)
            .orElseThrow { IllegalArgumentException("Usuario no encontrado") }

        userDao.deleteUser(userEntity)
        return "El usuario con id $id fue eliminado"
    }
}
