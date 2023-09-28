package com.example.fakepopfit.storage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.fakepopfit.data.Exercise
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise WHERE title = :id")
    fun getById(id: String): Flow<Exercise>

    @Query("SELECT * FROM exercise")
    fun getAllExercise(): LiveData<List<Exercise>>

    @Insert
    fun insertExercise(exercise: Exercise)

    @Update
    fun updateExercise(exercise: Exercise)

    @Delete
    fun deleteExercise(exercise: Exercise)
}