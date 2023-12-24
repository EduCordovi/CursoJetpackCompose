package com.educordovi.jetpackcompisecatalogo

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.runtime.*

@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismis: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { onDismis }) {
            Card(border = BorderStroke(5.dp, Color.Cyan)) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    MyTitleDialog(
                        text = "Phone ringtone",
                        color = Color.Black,
                        Modifier = Modifier.padding(24.dp)
                    )
                    Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
                    var status by remember { mutableStateOf("") }
                    MyRadioButtonList(status) { status = it }
                    Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
                    Row(
                        Modifier
                            .align(Alignment.End)
                            .padding(8.dp)
                    ) {
                        TextButton(onClick = { }) {
                            Text(text = "CANCEL")
                        }
                        TextButton(onClick = { }) {
                            Text(text = "OK")
                        }
                    }
                }
            }


        }

    }
}

@Composable
fun MyCustomDialog(
    show: Boolean,
    onDismis: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { onDismis }) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog("Set backup account", Color.Black, Modifier = Modifier.padding(12.dp))
                AccountItem(email = "Ejemplo1@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "Ejemplo2@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "Añadir nueva cuenta", drawable = R.drawable.add)
            }
        }
    }
}

@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDismis: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismis() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Text(text = "Esto es un ejemplo")
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Esto es un ejemplo", color = Color.Black)
            }

        }
    }
}

@Composable
fun MyDialog(   //AlertDialog
    show: Boolean,
    onDismis: () -> Unit, onConfirm
    : () -> Unit
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

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}


@Composable
fun MyTitleDialog(text: String, color: Color, Modifier: Modifier) {
    Text(
        text = text,
        color = color,
        fontSize = 20.sp,
        modifier = Modifier
    )
}
