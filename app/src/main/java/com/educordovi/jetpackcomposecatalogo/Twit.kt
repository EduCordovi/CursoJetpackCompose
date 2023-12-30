package com.educordovi.jetpackcomposecatalogo


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.educordovi.jetpackcompisecatalogo.R


@Composable
fun RetoTwit(darkTheme: Boolean) {
    Row(
        modifier = Modifier
            .padding(12.dp, 12.dp, 15.dp, 6.dp)
    ) {

        ProfileImage()
        Body(darkTheme)
        Footer(darkTheme)
    }
}

@Composable
fun Footer(darkTheme: Boolean) {

    val color: Color = if (darkTheme) {
        Color(0xFF7E7E7E)
    } else {
        Color(0xFF000000)
    }

    Divider(
        Modifier
            .height(2.dp),
        color = color
    )
}

@Composable
fun Body(darkTheme: Boolean) {


    val color: Color = if (darkTheme) {
        Color(0xFFFDFDFD)
    } else {
        Color(0xFF000000)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TextHeader(color)
        InfoBody()
        BodyFooter()

    }
}

@Composable
fun IconShare() {
    var selectedShare by rememberSaveable { mutableStateOf(false) }
    var valor = 1
    val valTint: Color

    if (selectedShare) {
        valTint = Color(0xFF1F6EAC)
        valor += valor
    } else {
        valTint = Color(0xFF7E7E7E)
        valor = 1
    }
    Icon(
        painter = painterResource(id = R.drawable.ic_share),
        contentDescription = "dots",
        modifier = Modifier
            .clickable { selectedShare = !selectedShare },
        tint = valTint
    )
    Text(text = valor.toString(), modifier = Modifier.padding(3.dp), color = Color(0xFF7E7E7E))
}

@Composable
fun IconLike() {
    var selectedLike by rememberSaveable { mutableStateOf(false) }
    val drawableVal: Int
    var valor = 1
    val valTint: Color

    if (selectedLike) {
        drawableVal = R.drawable.ic_like_filled
        valTint = Color(0xFFF30000)
        valor += valor
    } else {
        drawableVal = R.drawable.ic_like
        valTint = Color(0xFF7E7E7E)
        valor = 1
    }

    Icon(
        painter = painterResource(id = drawableVal),
        contentDescription = "dots",
        modifier = Modifier
            .clickable { selectedLike = !selectedLike },
        tint = valTint
    )
    Text(text = valor.toString(), modifier = Modifier.padding(3.dp), color = Color(0xFF7E7E7E))
}

@Composable
fun IconRt() {
    var selectedRt by rememberSaveable { mutableStateOf(false) }
    var valor = 1
    val valTint: Color

    if (selectedRt) {
        valTint = Color(0xFF43B848)
        valor += valor
    } else {
        valTint = Color(0xFF7E7E7E)
        valor = 1
    }

    Icon(
        painter = painterResource(id = R.drawable.ic_rt),
        contentDescription = "dots",
        modifier = Modifier
            .clickable { selectedRt = !selectedRt },
        tint = valTint,
    )
    Text(text = valor.toString(), modifier = Modifier.padding(3.dp), color = Color(0xFF7E7E7E))
}

@Composable
fun IconChat() {
    var selectedChat by rememberSaveable { mutableStateOf(false) }
    val drawableVal: Int
    var valor = 1

    if (selectedChat) {
        drawableVal = R.drawable.ic_chat_filled
        valor += valor
    } else {
        drawableVal = R.drawable.ic_chat
        valor = 1
    }

    Icon(
        painter = painterResource(id = drawableVal),
        contentDescription = "dots",
        modifier = Modifier
            .clickable { selectedChat = !selectedChat },
        tint = Color(0xFF7E7E7E)
    )
    Text(text = valor.toString(), modifier = Modifier.padding(3.dp), color = Color(0xFF7E7E7E))
}

@Composable
fun BodyFooter() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(15.dp), horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Row {
                IconChat()
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Row {
                IconRt()
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Row {
                IconLike()

            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Row {
                IconShare()

            }
        }
    }

}

@Composable
fun InfoBody() {
    Column(Modifier.padding(12.dp, 0.dp)) {
        Text(
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown " +
                    "printer took a galley of type and scrambled it to make a type specimen book.",
            textAlign = TextAlign.Justify, color = Color.White
        )

        Spacer(modifier = Modifier.size(10.dp))

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "profile",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(10)),
            contentScale = ContentScale.Crop
        )

    }
}

@Composable
fun TextHeader(color: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp, 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = "ECP", fontWeight = FontWeight.Bold, color = Color.White)
        }
        Column(
            modifier = Modifier
                .padding(5.dp)
        ) {
            Text(text = "@EduCordovi", color = Color(0xFF7E7E7E))
        }
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(text = "1h", color = Color(0xFF7E7E7E))
        }
        Column {
            Icon(
                painter = painterResource(id = R.drawable.ic_dots),
                contentDescription = "dots",
                tint = color
            )
        }


    }
}

@Composable
fun ProfileImage() {

    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "profile",
        modifier = Modifier
            .clip(CircleShape)
            .size(60.dp)
    )

}
