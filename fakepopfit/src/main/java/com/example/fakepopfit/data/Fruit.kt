package com.example.fakepopfit.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Fruit(
    val name: String,
    @PrimaryKey
    val id: Int,
    val family: String,
    val order: String,
    val genus: String,
    val nutritions: Nutritions
)