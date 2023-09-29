package com.example.fakepopfit.domain

import com.example.fakepopfit.storage.FruitDao
import javax.inject.Inject

class GetAllFruitsFromDbUseCase @Inject constructor(private val fruitDao: FruitDao) {

    fun getAllFruits() = fruitDao.getAllFruits()

}