package com.example.demo.presentation.dto

data class UserDTO(
    val id: Long = 0L,
    val name: String = "",
    val lastName: String = "",
    val email: String = "",
    val age: Int = 0
)
