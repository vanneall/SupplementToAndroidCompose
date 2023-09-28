package com.example.fakepopfit.domain

import com.example.fakepopfit.data.Exercise
import com.example.fakepopfit.data.ExerciseRepository
import javax.inject.Inject

class GetByIdUseCase @Inject constructor(private val repository: ExerciseRepository) {

    fun getById(id: Int) : Exercise{
        return repository.getById(id)
    }

}