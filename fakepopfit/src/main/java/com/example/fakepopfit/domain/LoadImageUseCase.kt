package com.example.fakepopfit.domain

import com.example.fakepopfit.data.ImageSharedPrefRepImpl
import javax.inject.Inject

class LoadImageUseCase @Inject constructor(private val sharedPreferences: ImageSharedPrefRepImpl) {

    fun loadImage(uri: String) {
        sharedPreferences.load(uri)
    }

}