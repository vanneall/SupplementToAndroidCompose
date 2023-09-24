package com.example.fakepopfit.data

data class Exercise(
    val id: Int = 0,
    var title: String,
    var currentWeighInKg: Float,
    var upWeightInNextTime: Boolean
)
