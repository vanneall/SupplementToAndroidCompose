package com.example.fakepopfit.presenter.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fakepopfit.data.Exercise
import com.example.fakepopfit.presenter.add_screen.TopBar

@Composable
fun ExerciseInfo(exercise: Exercise, navController: NavController) {

    TopBar(text = exercise.title, onClick = { navController.popBackStack() })

}

@Composable
fun CurrentWeightRow(weight: MutableState<Exercise>, modifier: Modifier = Modifier) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Текущий рабочий вес",
            color = Color.Black,
            fontSize = 16.sp,
        )
        OutlinedTextField(
            value = weight.value.currentWeighInKg.toString(),
            onValueChange = { it: String -> weight.value.currentWeighInKg = it.toFloat() },
            label = { Text(text = "Вес")}
        )
    }

}