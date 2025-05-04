package com.example.demo.service.implementation

import com.example.demo.persistence.entity.UserEntity
import com.example.demo.presentation.dto.UserDTO

fun UserEntity.toDTO(): UserDTO = UserDTO(
    id = this.id,
    name = this.name,
    lastName = this.lastName,
    email = this.email,
    age = this.age
)

fun UserDTO.toEntity(): UserEntity = UserEntity(
    id = this.id,
    name = this.name,
    lastName = this.lastName,
    email = this.email,
    age = this.age
)
