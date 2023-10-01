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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import coil.compose.AsyncImage
import com.example.fakepopfit.utils.MyWorkManager

@Composable
fun ImageScreen(imageScreenViewModel: ImageScreenViewModel) {
    val context = LocalContext.current
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
        Button(onClick = {
            val delaySeconds = 10
            val inputData = Data.Builder().putInt("delaySeconds", delaySeconds).build()
            val workRequest = OneTimeWorkRequest.Builder(MyWorkManager::class.java)
                .setInputData(inputData)
                .build()

            WorkManager.getInstance(context).enqueue(workRequest)

        }) {
            Text(text = "Установить таймер")
        }
    }
}