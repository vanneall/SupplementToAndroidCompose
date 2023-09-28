package com.example.fakepopfit.domain

import com.example.fakepopfit.data.ExerciseRepository
import javax.inject.Inject

class GetAllExerciseUseCase @Inject constructor(private val repository: ExerciseRepository) {
    fun getAllExercise() = repository.getAllExercise()
}