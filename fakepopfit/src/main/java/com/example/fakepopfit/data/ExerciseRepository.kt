package com.example.fakepopfit.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

interface ExerciseRepository {
    fun getAllExercise(): LiveData<List<Exercise>>
    fun getById(id: String): Flow<Exercise>
    suspend fun insert(exercise: Exercise)
    suspend fun update(exercise: Exercise)
    suspend fun delete(exercise: Exercise)

}