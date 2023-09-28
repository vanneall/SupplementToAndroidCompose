package com.example.fakepopfit.presenter.add_screen

import androidx.lifecycle.ViewModel
import com.example.fakepopfit.data.Exercise
import com.example.fakepopfit.domain.InsertUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddExerciseViewModel @Inject constructor(private val insertUseCase: InsertUseCase) : ViewModel() {

    fun insertUser(title: String, weight: Float) {
        insertUseCase.insert(
            Exercise(
                title = title,
                currentWeighInKg = weight,
                upWeightInNextTime = false
            )
        )
    }

}