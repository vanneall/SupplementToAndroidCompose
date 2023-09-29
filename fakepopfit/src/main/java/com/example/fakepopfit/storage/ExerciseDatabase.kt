package com.example.fakepopfit.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fakepopfit.data.Exercise
import com.example.fakepopfit.data.Fruit
import com.example.fakepopfit.data.NutritionsConverter

@Database(entities = [Exercise::class, Fruit::class], version = 2)
@TypeConverters(NutritionsConverter::class)
abstract class ExerciseDatabase : RoomDatabase() {
    abstract fun createExerciseDao(): ExerciseDao
    abstract fun createFruitDao(): FruitDao

}