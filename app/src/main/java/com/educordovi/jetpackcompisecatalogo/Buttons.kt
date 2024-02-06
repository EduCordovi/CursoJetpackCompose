package com.educordovi.jetpackcompisecatalogo

import android.provider.SyncStateContract.Columns
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyButton() {
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Holi1")
    }
}

@Composable
fun MyButton2() {
    Button(
        onClick = { /*TODO*/ },
        enabled = false,
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = Color.Red,
            disabledContentColor = Color.Blue
        )
    ) {
        Text(text = "Holi2")
    }
}

@Composable
fun MyFilledTonalButton() {
    FilledTonalButton(onClick = { /*TODO*/ }) {
        Text(text = "Holi3")
    }
}

@Composable
fun MyElevatedButton() {
    ElevatedButton(onClick = { /*TODO*/ }) {
        Text(text = "Holi4")
    }
}

@Preview
@Composable
fun MyAllFloatingActionButton() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(24.dp)) {

        LargeFloatingActionButton(onClick = { /*TODO*/ }, containerColor = Color.Red) {
            Icon(Icons.Filled.Favorite, "Floating Action button")
        }

        Spacer(modifier = Modifier.height(8.dp))

        FloatingActionButton(onClick = { /*TODO*/ }, containerColor = Color.Red) {
            Icon(Icons.Filled.Favorite, "Floating Action button")
        }

        Spacer(modifier = Modifier.height(8.dp))

        SmallFloatingActionButton(onClick = { /*TODO*/ }, containerColor = Color.Red) {
            Icon(Icons.Filled.Favorite, "Floating Action button")
        }

        Spacer(modifier = Modifier.height(8.dp))

        ExtendedFloatingActionButton(onClick = { print("hello") },
            text = { Text(text ="Extended FAB")},
            icon = {Icon(Icons.Filled.Favorite, "Floating Action Button Extended")})


    }
}