package com.example.fakepopfit.domain

import com.example.fakepopfit.data.Fruit
import com.example.fakepopfit.data.FruitRepository
import javax.inject.Inject

class GetAllFruitsUseCase @Inject constructor(private val api: FruitRepository) {
    suspend fun getAllFruits() : List<Fruit> {
        return api.getFruitInfo()
    }
}