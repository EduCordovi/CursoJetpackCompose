package com.educordovi.jetpackcompisecatalogo

import android.graphics.drawable.AdaptiveIconDrawable
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


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
                MyTitleDialog("Set backup account", Color.Black)
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
fun MyTitleDialog(text: String, color: Color) {
    Text(
        text = text,
        color = color,
        fontSize = 20.sp,
        modifier = Modifier.padding(12.dp)
    )
}
