package com.example.fakepopfit.presenter.image_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ImageScreen(imageScreenViewModel: ImageScreenViewModel) {

    val url = remember {
        mutableStateOf("")
    }

    val imageUrl = remember {
        mutableStateOf(imageScreenViewModel.get())
    }
    Column(
        modifier = Modifier
            .padding(top = 100.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = imageUrl.value,
            contentDescription = null,
            modifier = Modifier.padding(top = 60.dp)
        )
        TextField(
            value = url.value,
            onValueChange = { url.value = it },
            label = { Text(text = "URL") },
        )
        Button(onClick = {
            imageScreenViewModel.load(url.value)
            imageUrl.value = imageScreenViewModel.get()!!
        }) {
            Text(text = "Загрузить")
        }
    }
}