package com.example.fakepopfit.presenter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fakepopfit.data.Exercise
import com.example.fakepopfit.navigation.NavigationScreens

@Composable
fun MainScreen(navController: NavController) {
    val list = remember {
        mutableStateOf(
            listOf(
                Exercise(0, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(1, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(2, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(3, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(4, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(5, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(6, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(7, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(8, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(9, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(10, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(11, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(12, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(13, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(14, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(15, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(16, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(17, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(18, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false),
                Exercise(19, "Жим лежа", currentWeighInKg = 1.45f, upWeightInNextTime = false)
            )
        )

    }
    val state = rememberLazyListState()
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            state = state,
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(vertical = 30.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                Text(text = "Упражнения",
                    fontSize = 24.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp)
                )

            }

            items(
                items = list.value,
                key = { it.id }
            ) {
                ExerciseListItem(
                    title = it.title,
                    info = it.currentWeighInKg.toString(),
                    modifier = Modifier
                        .width(360.dp)
                        .height(90.dp)
                )
            }
        }
        FloatingActionButton(
            onClick = { navController.navigate(NavigationScreens.ADD_EXERCISE) },
            shape = CircleShape,
            content = { Icon(imageVector = Icons.Default.Add, contentDescription = "Add") },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 30.dp, bottom = 70.dp)
                .size(70.dp)
        )
    }
}
