package com.example.fakepopfit.presenter.info_screen

import androidx.lifecycle.ViewModel
import com.example.fakepopfit.data.Exercise
import com.example.fakepopfit.domain.DeleteUseCase
import com.example.fakepopfit.domain.GetByIdUseCase
import com.example.fakepopfit.domain.UpdateUseCase
import javax.inject.Inject

class InfoViewModel @Inject constructor(
    private val updateUseCase: UpdateUseCase,
    private val deleteUseCase: DeleteUseCase,
    private val getByIdUseCase: GetByIdUseCase
) : ViewModel() {
    lateinit var initExercise: Exercise

    fun setInitialExercise(id: Int) {
        initExercise = getByIdUseCase.getById(id)
    }

    private fun isTheSameObject(newExercise: Exercise) = initExercise == newExercise

    fun update(newExercise: Exercise) {
        if (!isTheSameObject(newExercise)) {
            updateUseCase.update(exercise = newExercise)
        }
    }

    fun delete(exercise: Exercise) {
        deleteUseCase.delete(exercise)
    }
}