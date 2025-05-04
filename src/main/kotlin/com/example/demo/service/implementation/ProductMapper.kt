package com.example.demo.service.implementation

import com.example.demo.persistence.entity.ProductEntity
import com.example.demo.presentation.dto.ProductDTO

fun ProductEntity.toDTO() = ProductDTO(
    id = this.id,
    category = this.category,
    title = this.title,
    actor = this.actor,
    price = this.price,
    special = this.special,
    commonProdId = this.commonProdId
)

fun ProductDTO.toEntity() = ProductEntity(
    id = this.id,
    category = this.category,
    title = this.title,
    actor = this.actor,
    price = this.price,
    special = this.special,
    commonProdId = this.commonProdId
)
