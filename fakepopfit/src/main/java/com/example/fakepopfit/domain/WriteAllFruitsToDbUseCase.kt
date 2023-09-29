package com.example.fakepopfit.domain

import com.example.fakepopfit.data.Fruit
import com.example.fakepopfit.storage.FruitDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class WriteAllFruitsToDbUseCase @Inject constructor(private val fruitDao: FruitDao) {
    fun writeAllFruitsToDb(fruits: List<Fruit>) {
        CoroutineScope(Dispatchers.IO).launch {
            for (fruit in fruits) {
                fruitDao.insertFruit(fruit)
            }
        }
    }
}