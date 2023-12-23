package com.educordovi.jetpackcompisecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@Composable
fun MySimpleCustomDialopg(
    show: Boolean,
    onDismis: () -> Unit,
) {
    if (show) {
        Dialog(onDismissRequest = { onDismis() }, properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)) {
            Text(text = "Esto es un ejemplo")
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Esto es un ejemplo",color = Color.Black)
            }

        }
    }
}

@Composable
fun MyDialog(   //AlertDialog
    show: Boolean, onDismis: () -> Unit, onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(onDismissRequest = {},
            title = { Text(text = "Título") },
            text = { Text(text = "Hola soy una descripción.") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "ConfirmButton")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismis() }) {
                    Text(text = "DismisButton")
                }
            })
    }
}

