package com.example.fakepopfit.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fakepopfit.data.Exercise

@Database(entities = [Exercise::class], version = 1)
abstract class ExerciseDatabase : RoomDatabase() {
    abstract fun createDatabase(): ExerciseDao

}