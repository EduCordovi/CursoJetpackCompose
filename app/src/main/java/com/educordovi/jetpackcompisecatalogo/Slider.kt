package com.educordovi.jetpackcompisecatalogo

import android.provider.SyncStateContract.Columns
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview


@Preview(showBackground = true)
@Composable
fun BasicSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPositions by remember { mutableStateOf(0f) }
        Slider(value = sliderPositions, onValueChange = { sliderPositions = it })
        Text(text = sliderPositions.toString())
    }

}