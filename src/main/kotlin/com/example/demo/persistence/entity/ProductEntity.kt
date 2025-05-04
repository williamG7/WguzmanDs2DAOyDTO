package com.example.demo.persistence.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "products")
data class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    val id: Long = 0,
    var category: Short = 0,
    var title: String = "",
    var actor: String = "",
    var price: BigDecimal = BigDecimal.ZERO,
    var special: Short = 0,
    @Column(name = "common_prod_id")
    var commonProdId: Int = 0
)
