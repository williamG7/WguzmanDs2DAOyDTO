package com.example.demo.presentation.controller

import com.example.demo.presentation.dto.UserDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.example.demo.service.interfaces.IUserService

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: IUserService
) {

    @GetMapping("/find")
    fun findAll(): ResponseEntity<List<UserDTO>> {
        val users = userService.findAll()
        return ResponseEntity.ok(users)
    }

    @GetMapping("/find/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<UserDTO> {
        val user = userService.findById(id)
        return ResponseEntity.ok(user)
    }

    @PostMapping("/create")
    fun createUser(@RequestBody userDTO: UserDTO): ResponseEntity<UserDTO> {
        val createdUser = userService.createUser(userDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser)
    }

    @PutMapping("/update/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody userDTO: UserDTO): ResponseEntity<UserDTO> {
        val updatedUser = userService.updateUser(id, userDTO)
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<String> {
        val message = userService.deleteUser(id)
        return ResponseEntity.ok(message)
    }
}
