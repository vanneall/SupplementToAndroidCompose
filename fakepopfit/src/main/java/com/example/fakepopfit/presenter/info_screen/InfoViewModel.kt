package com.example.fakepopfit.presenter.info_screen

import androidx.lifecycle.ViewModel
import com.example.fakepopfit.data.Exercise
import com.example.fakepopfit.domain.DeleteUseCase
import com.example.fakepopfit.domain.GetByIdUseCase
import com.example.fakepopfit.domain.UpdateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    private val updateUseCase: UpdateUseCase,
    private val deleteUseCase: DeleteUseCase,
    private val getByIdUseCase: GetByIdUseCase
) : ViewModel() {

    fun getById(id: String): Flow<Exercise> = getByIdUseCase.getById(id)

    fun update(newExercise: Exercise) {
        updateUseCase.update(exercise = newExercise)
    }

    fun delete(exercise: Exercise) {
        deleteUseCase.delete(exercise)
    }
}