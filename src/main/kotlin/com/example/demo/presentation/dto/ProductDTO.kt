package com.example.demo.presentation.dto

import java.math.BigDecimal

data class ProductDTO(
    val id: Long = 0,
    val category: Short,
    val title: String,
    val actor: String,
    val price: BigDecimal,
    val special: Short,
    val commonProdId: Int
)
