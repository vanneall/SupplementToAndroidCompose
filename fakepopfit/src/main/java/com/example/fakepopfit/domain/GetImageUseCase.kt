package com.example.fakepopfit.domain

import com.example.fakepopfit.data.ImageSharedPrefRepImpl
import javax.inject.Inject

class GetImageUseCase @Inject constructor(private val sharedPreferences: ImageSharedPrefRepImpl) {
    fun getImage(): String? = sharedPreferences.get()
}