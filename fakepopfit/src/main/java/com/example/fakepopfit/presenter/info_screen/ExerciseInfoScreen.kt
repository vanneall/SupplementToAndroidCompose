package com.example.fakepopfit.presenter.info_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fakepopfit.data.Exercise
import com.example.fakepopfit.presenter.add_screen.TopBar

@Composable
fun ExerciseInfoScreen(id: String, viewModel: InfoViewModel, navigateBack: () -> Unit) {

    val oldExercise = remember {
        mutableStateOf(
            Exercise(
                id = 0,
                title = "loading",
                currentWeighInKg = 1f,
                upWeightInNextTime = false
            )
        )
    }
    val title = oldExercise.value.title

    LaunchedEffect(
        key1 = "key",
        block = { viewModel.getById(id).collect() { oldExercise.value = it } })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    ) {
        TopBar(
            text = title,
            onClick = { navigateBack() })
        Spacer(modifier = Modifier.height(100.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Текущий вес",
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            OutlinedTextField(
                value = oldExercise.value.currentWeighInKg.toString(),
                onValueChange = {
                    oldExercise.value = Exercise(
                        oldExercise.value.id,
                        oldExercise.value.title,
                        it.toFloat(),
                        oldExercise.value.upWeightInNextTime
                    )
                },
                modifier = Modifier.size(height = 60.dp, width = 100.dp),
                label = { Text(text = "Вес") }
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Повысить в следующий раз",
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Switch(
                checked = oldExercise.value.upWeightInNextTime,
                onCheckedChange = {
                    oldExercise.value = Exercise(
                        oldExercise.value.id,
                        oldExercise.value.title,
                        oldExercise.value.currentWeighInKg,
                        it
                    )
                }
            )
        }

        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = {
                navigateBack()
                viewModel.delete(oldExercise.value)
            }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "delete")
            }
            Spacer(modifier = Modifier.width(5.dp))
            Button(onClick = { navigateBack() }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "close_screen",
                )
                Text(text = "Отменить", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                navigateBack()
                viewModel.update(oldExercise.value)
            }) {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "save",
                )
                Text(text = "Сохранить", fontSize = 16.sp)
            }
        }
    }
}