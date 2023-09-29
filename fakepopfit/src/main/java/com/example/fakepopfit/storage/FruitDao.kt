package com.example.fakepopfit.storage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fakepopfit.data.Fruit

@Dao
interface FruitDao {

    @Query("DELETE FROM fruit")
    suspend fun clearAll()

    @Insert
    suspend fun insertFruit(fruit: Fruit)

    @Query("SELECT * FROM fruit")
    fun getAllFruits(): LiveData<List<Fruit>>

}