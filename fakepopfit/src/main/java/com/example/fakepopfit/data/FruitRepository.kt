package com.example.fakepopfit.data

interface FruitRepository {
    suspend fun getFruitInfo() : List<Fruit>
}