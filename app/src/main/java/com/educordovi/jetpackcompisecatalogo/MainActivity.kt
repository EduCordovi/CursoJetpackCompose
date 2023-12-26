package com.educordovi.jetpackcompisecatalogo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.educordovi.jetpackcompisecatalogo.ui.CheckInfo
import com.educordovi.jetpackcompisecatalogo.ui.theme.JetpackCompiseCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompiseCatalogoTheme {
                // A surface container using the 'background' color from the theme
                /*ESto es necesario para la funcion MyRadioButtonList*/
                var selected by remember {
                    mutableStateOf("Ejemplo 1")
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    /*Esta parte se necesita para la funcion MyTextField
                    * var myText by remember { mutableStateOf("Eduardo") }
                    * MyTextField(myText) {myText = it}
                    *  */

                    /*
                    Esta parte la necesito para ver los CheckBox
                    val myOption = getOptions(listOf("Eduardo","Eucaris","Emily","Liam"))
                    Column() {
                        MYTriStatusCheckBox()
                        myOption.forEach {
                            MyCheckBoxWithTextCompleted(it)
                        }
                    }*/

                    /*Seccion usada para la funcion MyDialog descomenta aca y lo veras

                    var show by remember { mutableStateOf(false) }

                    Box(modifier = Modifier.fillMaxSize()) {
                        Button(onClick = { show = true }) {
                            Text(text = "Mostrar Diálogo")
                        }

                        MyDialog(
                            show = show,
                            onDismis = { show = false },
                            onConfirm = { Log.i("EdCordovi", "Click") })
                    }*/

                    /*Seccion usada para la funcion MyConfirmationDialog, MyCustomDialog, MySimpleCustomDialog descomenta aca y lo veras
                   var show by remember { mutableStateOf(false) }
                   Column(horizontalAlignment = Alignment.CenterHorizontally) {
                       Box(modifier = Modifier.fillMaxSize()) {
                           Button(onClick = { show = true }) {
                               Text(text = "Mostrar Diálogo")
                           }

                           MyConfirmationDialog(
                               show = show,
                               onDismis = { show = false })
                       }
                   }*/

                   LoginScreen()

               }
           }
       }
   }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   JetpackCompiseCatalogoTheme {


       MyDropDownMenu()

   }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu() {
   var selectedText by remember { mutableStateOf("") }
   var expanded by remember { mutableStateOf(false) }
   val desserts = listOf("Helado", "Chocolate", "Café", "Fruta", "Natillas", "Chilaquiles")
   Column(Modifier.padding(20.dp)) {
       OutlinedTextField(
           value = selectedText,
           onValueChange = { selectedText = it },
           enabled = false,
           readOnly = true,
           modifier = Modifier
               .clickable { expanded = true }
               .fillMaxWidth()
       )
       DropdownMenu(
           expanded = expanded,
           onDismissRequest = { expanded = false },
           modifier = Modifier.fillMaxWidth()
       ) {
           desserts.forEach { desserts ->
               DropdownMenuItem(text = { Text(text = desserts) }, onClick = {
                   expanded = false
                   selectedText = desserts
               })
           }
       }
   }
}

@Composable
fun MyDivider() {
   Divider(
       Modifier
           .fillMaxWidth()
           .padding(top = 16.dp), color = Color.Red
   )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgedBox() {
   Column(
       Modifier
           .padding(16.dp)
   ) {
       BadgedBox(
           badge = {
               Badge(
                   containerColor = Color.Blue,
                   contentColor = Color.Green
               ) {
                   Text(text = "10")
               }
           }
       )
       {
           Icon(imageVector = Icons.Default.Star, contentDescription = "Estrella")
       }
   }
}

@Composable
fun MyCard() {
   Card(
       modifier = Modifier
           .fillMaxWidth()
           .padding(16.dp),
       elevation = cardElevation(defaultElevation = 32.dp),
       shape = MaterialTheme.shapes.large,
       colors = CardDefaults.cardColors(
           containerColor = Color.Red,
           contentColor = Color.Green
       ),
       border = BorderStroke(5.dp, Color.Blue)
   ) {
       Column(modifier = Modifier.padding(16.dp)) {
           Text(text = "Ejemplo 1")
           Text(text = "Ejemplo 2")
           Text(text = "Ejemplo 3")
       }
   }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

   Column(Modifier.fillMaxWidth()) {
       Row(verticalAlignment = Alignment.CenterVertically) {
           RadioButton(selected = name == "Ejemplo 1", onClick = { onItemSelected("Ejemplo 1") })
           Text("Ejemplo 1", color = Color.Black)
       }
       Row(verticalAlignment = Alignment.CenterVertically) {
           RadioButton(selected = name == "Ejemplo 2", onClick = { onItemSelected("Ejemplo 2") })
           Text("Ejemplo 2", color = Color.Black)
       }
       Row(verticalAlignment = Alignment.CenterVertically) {
           RadioButton(selected = name == "Ejemplo 3", onClick = { onItemSelected("Ejemplo 3") })
           Text("Ejemplo 3", color = Color.Black)
       }
       Row(verticalAlignment = Alignment.CenterVertically) {
           RadioButton(selected = name == "Ejemplo 4", onClick = { onItemSelected("Ejemplo 4") })
           Text("Ejemplo 4", color = Color.Black)
       }
   }
}

@Composable
fun MyRadioButton() {

   Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
       RadioButton(
           selected = false, onClick = { }, enabled = true, colors = RadioButtonDefaults.colors(
               selectedColor = Color.Red,
               unselectedColor = Color.Yellow,
               disabledSelectedColor = Color.Green.copy(0.2f),
               disabledUnselectedColor = Color.Green.copy(0.2f)
           )
       )
       Text("Ejemplo 1")
   }
}

@Composable
fun MYTriStatusCheckBox() {
   var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
   TriStateCheckbox(state = status, onClick = {
       status = when (status) {
           ToggleableState.On -> ToggleableState.Off
           ToggleableState.Off -> ToggleableState.Indeterminate
           ToggleableState.Indeterminate -> ToggleableState.On
       }
   })
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {

   return titles.map {
       var status by rememberSaveable { mutableStateOf(false) }
       CheckInfo(
           title = it,
           selected = status,
           onCheckedChange = { myNewStatus -> status = myNewStatus }
       )
   }


}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {

   Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
       Checkbox(
           checked = checkInfo.selected,
           onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
       Spacer(modifier = Modifier.width(8.dp))
       Text(text = checkInfo.title)

   }
}

@Composable
fun MyCheckBoxWithText() {

   var state by rememberSaveable { mutableStateOf(true) }

   Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
       Checkbox(checked = state, onCheckedChange = { state = !state })
       Spacer(modifier = Modifier.width(8.dp))
       Text(text = "Ejemplo 1")

   }
}

@Composable
fun MyCheckBox() {
   var state by rememberSaveable { mutableStateOf(true) }

   Checkbox(
       checked = state,
       onCheckedChange = { state = !state },
       enabled = true,
       colors = CheckboxDefaults.colors(
           checkedColor = Color.Red,
           uncheckedColor = Color.Yellow,
           checkmarkColor = Color.Blue
       )
   )
}

@Composable
fun MySwitch() {
   var state by rememberSaveable { mutableStateOf(true) }

   Switch(
       checked = state,
       onCheckedChange = { state = !state },
       enabled = true,
       colors = SwitchDefaults.colors(
           uncheckedThumbColor = Color.Red,
           checkedThumbColor = Color.Green,
           checkedTrackColor = Color.Magenta,
           uncheckedTrackColor = Color.Cyan
       )
   )
}

@Composable
fun MyProgressAdvance() {

   var progressStatus by rememberSaveable { mutableStateOf(0f) }


   Column(
       Modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
       CircularProgressIndicator(progress = progressStatus)

       Row(Modifier.fillMaxWidth()) {
           Button(onClick = { if (progressStatus <= 1) progressStatus += 0.1f }) {
               Text(text = "Incrementar")
           }

           Button(onClick = { if (progressStatus > 0.1f) progressStatus -= 0.1f }) {
               Text(text = "Reducir")
           }
       }
   }
}

@Composable
fun MyProgress() {

   var showLoading by rememberSaveable {
       mutableStateOf(false)
   }

   Column(
       Modifier
           .padding(24.dp)
           .fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
       if (showLoading) {
           CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp)
           LinearProgressIndicator(
               modifier = Modifier.padding(top = 32.dp),
               color = Color.Red,
               trackColor = Color.Green
           )
       }
       Button(onClick = { showLoading = !showLoading }) {
           Text(text = "Cargar Perfil")
       }
   }
}

/*
* Una forma de conseguir mas iconos se debe de agregar al Gradle la libreria
* implementation("androidx.compose.material:material-icons-extended:1.3.1")
* y sincronizar y ya apareceria en el Icons.Rounded mas iconos
* Estos son los de la pagina https://fonts.google.com/icons
* */
@Composable
fun MyIcon() {
   Icon(
       imageVector = Icons.Rounded.Star,
       contentDescription = "Icono",
       tint = Color.Red
   )
}

/*
* Se se usa RoundedCornerShape(25f) puedes crear los border redondeados dependiendo del
* valor que le pongas
* */
@Composable
fun MyImageAdvance() {
   Image(
       painter = painterResource(id = R.drawable.ic_launcher_background),
       contentDescription = "Ejemplo",
       modifier = Modifier
           .clip(CircleShape)
           .border(5.dp, Color.Red, CircleShape)
   )
}

/*alpha maneja la opacidad de la imagen*/
@Composable
fun MyImage() {
   Image(
       painter = painterResource(id = R.drawable.ic_launcher_background),
       contentDescription = "Ejemplo",
       alpha = 0.5f
   )
}

/*Aca puedo usar pesos por ejemplos
* Spacer(modifier = Modifier.height(1f))
* seria ver como podremos hacer una funcion para pasar esto
* */
@Composable
fun MySpacer(sizeH: Int, sizeW: Int) {
   Spacer(modifier = Modifier.height(sizeH.dp))
   Spacer(modifier = Modifier.width(sizeW.dp))
}

@Composable
fun Ejercicio1() {
   Column(Modifier.fillMaxSize()) {
       Box(
           Modifier
               .fillMaxWidth()
               .weight(1f)
               .background(Color.Cyan), contentAlignment = Alignment.Center
       ) {
           Text(text = "Ejemplo 1")
       }
       Row(
           Modifier
               .fillMaxWidth()
               .weight(1f)
       ) {
           Box(
               modifier = Modifier
                   .weight(1f)
                   .fillMaxHeight()
                   .background(Color.Red), contentAlignment = Alignment.Center
           ) {
               Text(text = "Ejemplo 2")
           }
           Box(
               modifier = Modifier
                   .weight(1f)
                   .fillMaxHeight()
                   .background(Color.Green), contentAlignment = Alignment.Center
           ) {
               Text(text = "Ejemplo 3")
           }
       }
       Box(
           Modifier
               .fillMaxWidth()
               .weight(1f)
               .background(Color.Magenta), contentAlignment = Alignment.BottomCenter
       ) {
           Text(text = "Ejemplo 4")
       }
   }
}

@Composable
fun MyComplexLayout() {
   Column(Modifier.fillMaxSize()) {
       Box(
           Modifier
               .fillMaxWidth()
               .weight(1f)
               .background(Color.Cyan)
       ) {

       }
       MySpacer(30, 0)
       Row(
           Modifier
               .fillMaxWidth()
               .weight(1f)
       ) {
           Box(
               modifier = Modifier
                   .weight(1f)
                   .fillMaxHeight()
                   .background(Color.Red)
           )
           MySpacer(0, 30)
           Box(
               modifier = Modifier
                   .weight(1f)
                   .fillMaxHeight()
                   .background(Color.Green), contentAlignment = Alignment.Center
           ) {
               Text(text = "Hola Soy Eduardo")
           }
       }
       MySpacer(30, 0)
       Box(
           Modifier
               .fillMaxWidth()
               .weight(1f)
               .background(Color.Magenta)
       ) {
       }
   }
}

@Composable
fun MyRow() {
   //Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
   //    Text(text = "Ejemplo1")
   //    Text(text = "Ejemplo1")
   //    Text(text = "Ejemplo1")
   //}
   Row(
       Modifier
           .fillMaxSize()
           .horizontalScroll(rememberScrollState()),
       horizontalArrangement = Arrangement.SpaceBetween
   ) {
       Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
       Text(text = "Ejemplo2", modifier = Modifier.width(100.dp))
       Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
       Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
       Text(text = "Ejemplo2", modifier = Modifier.width(100.dp))
       Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
       Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
       Text(text = "Ejemplo2", modifier = Modifier.width(100.dp))
       Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
   }
}

@Composable
fun MyColumn() {
   Column(
       Modifier
           .fillMaxSize()
           .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
   ) {
       Text(
           text = "Ejemlplo1", modifier = Modifier
               .background(Color.Red)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo2", modifier = Modifier
               .background(Color.Black)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo3", modifier = Modifier
               .background(Color.Cyan)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo4", modifier = Modifier
               .background(Color.Blue)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo1", modifier = Modifier
               .background(Color.Red)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo2", modifier = Modifier
               .background(Color.Black)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo3", modifier = Modifier
               .background(Color.Cyan)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo4", modifier = Modifier
               .background(Color.Blue)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo1", modifier = Modifier
               .background(Color.Red)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo2", modifier = Modifier
               .background(Color.Black)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo3", modifier = Modifier
               .background(Color.Cyan)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo4", modifier = Modifier
               .background(Color.Blue)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo1", modifier = Modifier
               .background(Color.Red)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo2", modifier = Modifier
               .background(Color.Black)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo3", modifier = Modifier
               .background(Color.Cyan)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo4", modifier = Modifier
               .background(Color.Blue)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo1", modifier = Modifier
               .background(Color.Red)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo2", modifier = Modifier
               .background(Color.Black)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo3", modifier = Modifier
               .background(Color.Cyan)
               .fillMaxWidth()
               .height(100.dp)
       )
       Text(
           text = "Ejemlplo4", modifier = Modifier
               .background(Color.Blue)
               .fillMaxWidth()
               .height(100.dp)
       )
   }
}

@Composable
fun MyBox() {
   Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
       Box(
           modifier = Modifier
               .width(200.dp)
               .height(100.dp)
               .background(Color.Cyan)
               .verticalScroll(
                   rememberScrollState()
               )
       ) {
           Text("Me Esto es una prueba de texto")
       }
   }
}

@Composable
fun MyStateExample() {
   /*
       * El remember deja de funcionar al rotar la pantalla para tenerlo en cuenta
       * es decir si en vertical pulsas el boton 5 te lo dices pero si lo rotas horizontal
       * vuelve a 0
   * */

   var counter by rememberSaveable { mutableStateOf(0) }

   Column(
       Modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
       Button(onClick = { counter += 1 }) {
           Text(text = "Pulsar")
       }
       Text(text = "He sido pulsado $counter veces")
   }
}

@Composable
fun MyText() {
   Column(Modifier.fillMaxSize()) {
       Text(text = "Esto es un ejemplo")
       Text(text = "Esto es un ejemplo", color = Color.Blue)
       Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
       Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
       Text(text = "Esto es un ejemplo", fontFamily = FontFamily.Cursive)
       Text(
           text = "Esto es un ejemplo",
           textDecoration = TextDecoration.LineThrough
       )
       Text(
           text = "Esto es un ejemplo",
           textDecoration = TextDecoration.Underline
       )
       Text(
           text = "Esto es un ejemplo", style = TextStyle(
               textDecoration = TextDecoration.combine(
                   listOf(TextDecoration.LineThrough, TextDecoration.Underline)
               )
           )
       )
       Text(text = "Esto es un ejemplo", fontSize = 30.sp)
   }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(name: String, onValueChanged: (String) -> Unit) {

   TextField(value = name, onValueChange = { onValueChanged(it) })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvance() {
   var myText by remember { mutableStateOf("") }

   TextField(value = myText,
       onValueChange = {
           myText =
               if (it.contains("a")) {
                   it.replace("a", "")
               } else {
                   it
               }
       },
       label = { Text(text = "Introduce tu nombre") })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldOutlined() {
   var myText by remember { mutableStateOf("Eduardo") }
   Column() {
       OutlinedTextField(
           value = myText,
           onValueChange = { myText = it },
           modifier = Modifier.padding(24.dp),
           label = { Text(text = "Hola") },
           colors = TextFieldDefaults.outlinedTextFieldColors(
               focusedBorderColor = Color.Magenta,
               unfocusedBorderColor = Color.Blue,
           )
       )
   }
}

@Composable
fun MyButtonExample() {
   /*
   * Esto permite crear un estado para el botón para cuando se pulse se inhabilite
   * el rememberSavable permite se mantenga el cambio incluso cuando gire la pantalla
   * en caso de que esto no me interese puede usarse unicamente remember
   * */
   var enabled by rememberSaveable { mutableStateOf(true) }

   Column(
       Modifier
           .fillMaxSize()
           .padding(24.dp)
   ) {
       Button(
           onClick = { enabled = false },
           enabled = enabled,
           colors = ButtonDefaults.buttonColors(
               containerColor = androidx.compose.ui.graphics.Color.Red,
               contentColor = MaterialTheme.colorScheme.surface
           ),
           border = BorderStroke(5.dp, Color.Green)
       ) {
           Text("Hola")
       }

       OutlinedButton(
           onClick = { enabled = false },
           enabled = enabled,
           modifier = Modifier.padding(top = 8.dp),
           colors = ButtonDefaults.buttonColors(
               containerColor = Color.Magenta,
               contentColor = Color.Blue,
               disabledContainerColor = Color.Blue,
               disabledContentColor = Color.Red
           )
       ) {
           Text(text = "Hola")
       }

       /*
       * La diferencia con los otros es que no tiene borde el boton y es un texto clicleable
       * */
       TextButton(onClick = { /*TODO*/ }) {
           Text(text = "Hola")
       }
   }
}

