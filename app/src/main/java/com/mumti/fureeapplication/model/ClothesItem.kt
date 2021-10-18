package com.mumti.fureeapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class ClothesItem(
    val imageUrl: String = "",
    val longDescription: String = "",
    val name: String = "",
    val price: String = "",
    val store: String = "",
    val sizeChart: List<String> = emptyList()
)