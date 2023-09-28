package com.example.fakepopfit.domain

import com.example.fakepopfit.data.Exercise
import com.example.fakepopfit.data.ExerciseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DeleteUseCase @Inject constructor(private val repository: ExerciseRepository) {

    fun delete(exercise: Exercise) {
        CoroutineScope(Dispatchers.IO).launch { repository.delete(exercise) }
    }

}