package com.educordovi.jetpackcompisecatalogo

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun MyDialog(
    show: Boolean,
    onDismis: () -> Unit,
    onConfirm:() -> Unit
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
            }
        )
    }
}