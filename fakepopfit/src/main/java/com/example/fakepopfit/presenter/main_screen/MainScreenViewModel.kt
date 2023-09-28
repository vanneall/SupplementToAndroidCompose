package com.example.fakepopfit.presenter.main_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.fakepopfit.data.Exercise
import com.example.fakepopfit.domain.GetAllExerciseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val useCase: GetAllExerciseUseCase) :
    ViewModel() {
    fun getAllExercise(): LiveData<List<Exercise>> = useCase.getAllExercise()
}