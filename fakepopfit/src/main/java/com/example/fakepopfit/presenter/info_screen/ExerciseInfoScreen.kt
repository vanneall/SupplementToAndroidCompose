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
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fakepopfit.presenter.add_screen.TopBar

@Composable
fun ExerciseInfoScreen(id: Int, viewModel: InfoViewModel, navigateBack: () -> Unit) {
    viewModel.setInitialExercise(id)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    ) {
        TopBar(text = viewModel.initExercise.title, onClick = { navigateBack() })
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
                value = viewModel.initExercise.currentWeighInKg.toString(),
                onValueChange = {},
                modifier = Modifier.size(height = 50.dp, width = 100.dp),
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
            Switch(checked = viewModel.initExercise.upWeightInNextTime, onCheckedChange = null)
        }

        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Button(onClick = { navigateBack() }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "close_screen",
                )
                Text(text = "Отменить", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "save",
                )
                Text(text = "Сохранить", fontSize = 16.sp)
            }
        }
    }
}