package com.example.demo.service.interfaces

import com.example.demo.presentation.dto.UserDTO

interface IUserService {
    fun findAll(): List<UserDTO>
    fun findById(id: Long): UserDTO
    fun createUser(userDTO: UserDTO): UserDTO
    fun updateUser(id: Long, userDTO: UserDTO): UserDTO
    fun deleteUser(id: Long): String
}