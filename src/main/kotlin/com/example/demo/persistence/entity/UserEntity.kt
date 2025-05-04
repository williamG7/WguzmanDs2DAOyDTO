package com.example.demo.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,
    var name: String = "firstName",
    @Column(name = "last_name")
    var lastName: String = "lastName",
    var email: String = "email",
    var age: Int = 0
)
