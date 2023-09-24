package com.example.fakepopfit.presenter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExerciseListItem(title: String, info: String, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(corner = CornerSize(20.dp)),
        modifier = modifier.shadow(5.dp, shape = RoundedCornerShape(corner = CornerSize(20.dp)))
    ) {
        Row(
            modifier = modifier.padding(
                horizontal = 20.dp,
                vertical = 15.dp
            )
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = info,
                    fontSize = 14.sp
                )
            }
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxHeight(),
                imageVector = Icons.Default.Edit,
                contentDescription = "edit",
            )
        }
    }
}

@Preview
@Composable
fun CardPreview() {
    ExerciseListItem(
        title = "Жим гантелей лежа",
        info = "Текущий вес - 24кг",
        modifier = Modifier
            .width(360.dp)
            .height(100.dp)
    )
}

