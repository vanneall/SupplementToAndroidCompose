package com.example.fakepopfit.data

import androidx.lifecycle.LiveData

interface ExerciseRepository {
    fun getAllExercise(): LiveData<List<Exercise>>
    fun getById(id: Int): Exercise
    suspend fun insert(exercise: Exercise)
    suspend fun update(exercise: Exercise)
    suspend fun delete(exercise: Exercise)

}