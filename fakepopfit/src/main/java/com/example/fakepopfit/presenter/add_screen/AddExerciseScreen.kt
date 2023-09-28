package com.example.fakepopfit.presenter.add_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AddExerciseScreen(viewModel: AddExerciseViewModel, navigateBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    ) {

        TopBar(text = "Добавить упражнение", onClick = { navigateBack() })

        val titleMutableState = remember { mutableStateOf("") }
        OutlinedTextFieldWithInfo(
            hint = "Название",
            value = titleMutableState,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = 50.dp, start = 20.dp, end = 20.dp),
        )

        val weightMutableState = remember { mutableStateOf("") }
        OutlinedTextFieldWithInfo(
            hint = "Начальный вес",
            value = weightMutableState,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp, start = 20.dp, end = 20.dp),
        )

        FloatingActionButton(
            onClick = {
                viewModel.insertUser(
                    titleMutableState.value,
                    weightMutableState.value.toFloat()
                )
                navigateBack()
            },
            shape = CircleShape,
            content = { Icon(Icons.Default.Add, contentDescription = "add") },
            modifier = Modifier
                .padding(top = 20.dp, end = 20.dp)
                .align(Alignment.End)
        )
    }
}

@Composable
fun TopBar(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp)
    ) {
        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription = "back",
            modifier = modifier
                .size(30.dp)
                .align(Alignment.CenterVertically)
                .clickable { onClick() })
        Text(
            text = text,
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}

@Composable
fun OutlinedTextFieldWithInfo(
    hint: String,
    value: MutableState<String>,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value.value,
        onValueChange = { value.value = it },
        label = { Text(text = hint) },
        modifier = modifier,
        singleLine = true,
        maxLines = 1
    )
}
