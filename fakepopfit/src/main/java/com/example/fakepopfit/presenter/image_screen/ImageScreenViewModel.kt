package com.example.fakepopfit.presenter.image_screen

import androidx.lifecycle.ViewModel
import com.example.fakepopfit.domain.GetImageUseCase
import com.example.fakepopfit.domain.LoadImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageScreenViewModel @Inject constructor(
    private val getImageUseCase: GetImageUseCase,
    private val loadUseCase: LoadImageUseCase
) : ViewModel() {

    fun get() = getImageUseCase.getImage()

    fun load(uri: String) = loadUseCase.loadImage(uri)

}