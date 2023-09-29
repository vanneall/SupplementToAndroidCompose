package com.example.fakepopfit.presenter.fruit_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakepopfit.data.Fruit
import com.example.fakepopfit.domain.DeleteAllFruitsUseCase
import com.example.fakepopfit.domain.GetAllFruitsFromDbUseCase
import com.example.fakepopfit.domain.GetAllFruitsUseCase
import com.example.fakepopfit.domain.WriteAllFruitsToDbUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class FruitViewModel @Inject constructor(
    private val getAllFruitsUseCase: GetAllFruitsUseCase,
    private val writeAllFruitsToDbUseCase: WriteAllFruitsToDbUseCase,
    private val deleteAllFruitsUseCase: DeleteAllFruitsUseCase,
    private val getAllFruitsFromDbUseCase: GetAllFruitsFromDbUseCase
) : ViewModel() {

    var allFruits = getAllFruitsFromDbUseCase.getAllFruits()

    fun getFruitsFromServer() {
        viewModelScope.launch {
            try {
                val res = getAllFruitsUseCase.getAllFruits()
                writeToDb(res)
            } catch (ex: IOException) {
            }
        }
    }

    fun deleteFruits() {
        deleteAllFruitsUseCase.deleteAll()
    }

    private fun writeToDb(list: List<Fruit>) {
        writeAllFruitsToDbUseCase.writeAllFruitsToDb(list)
    }
}