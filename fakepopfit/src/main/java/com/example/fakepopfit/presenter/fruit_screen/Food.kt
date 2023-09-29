package com.example.fakepopfit.presenter.fruit_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Food(viewModel: FruitViewModel, modifier: Modifier = Modifier) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(onClick = { viewModel.deleteFruits() }) {
            Text(text = "Удалить")
        }

        Button(onClick = { viewModel.getFruitsFromServer() }) {
            Text(text = "Загрузить")
        }
    }

    val listState = viewModel.allFruits.observeAsState(initial = listOf())
    LazyColumn(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(top = 120.dp, start = 20.dp)
    ) {
        items(items = listState.value) {
            Column {
                Text(text = it.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = "БЖУ: ${it.nutritions.protein}г, ${it.nutritions.fat}г, ${it.nutritions.carbohydrates}г", fontSize = 14.sp)
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}