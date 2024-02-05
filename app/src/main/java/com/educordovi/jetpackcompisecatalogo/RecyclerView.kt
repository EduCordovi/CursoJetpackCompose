package com.educordovi.jetpackcompisecatalogo

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.educordovi.jetpackcompisecatalogo.model.SuperHero
import kotlinx.coroutines.launch
import kotlin.math.log

@Composable
fun SimpleRecyclerView() {

    val myList = listOf("Eduardo", "Ester", "Manolo", "Josefa")

    LazyColumn {
        item { Text(text = "Header") }
        items(7) {
            Text(text = "Este el item $it")
        }
        items(myList) {
            Text(text = "Hola me llamo $it")
        }
        item { Text(text = "Footer") }
    }
}

@Composable
fun SuperHeroGridView() {
    /*Puedo usar GridCells.Adaptive(100.dp) lo cual permite que el item tenga al menos 100 dp y mete ahi lo que ocupe hasta que se ajuste y lo que no lo pasa abajo*/
    val context = LocalContext.current
    LazyVerticalGrid(
        modifier = Modifier.padding(8.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(getSuperHeroes()) { superhero ->
                ItemHero(superHero = superhero)
                {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        })

}

@Composable
fun SuperHeroView() {

    val context = LocalContext.current

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroes()) { superhero ->
            ItemHero(superHero = superhero)
            {
                Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroStickyView() {

    val context = LocalContext.current
    val superhero: Map<String, List<SuperHero>> = getSuperHeroes().groupBy { it.publisher }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        superhero.forEach { (publisher, mySuperHero) ->

            stickyHeader {
                Text(
                    text = publisher,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black),
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

            items(mySuperHero) { superhero ->
                ItemHero(superHero = superhero)
                {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun SuperHeroWithSpecialControlsView() {
    /*
    * Este ejemplo permite controlar el desplazamiento
    * el boton nos permite que pasado los items de la lista aparezca el boton con los estados y al presionar el boton te
    * devuelve a la posicion de la lista que le indiques aca rvState.animateScrollToItem(0)
    * */
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutinesScope = rememberCoroutineScope()
    Column {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeroes()) { superhero ->
                ItemHero(superHero = superhero)
                {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
        val showbutton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }

        rvState.firstVisibleItemScrollOffset
        if (showbutton) {
            Button(
                onClick = {
                    coroutinesScope.launch { rvState.animateScrollToItem(0) }
                }, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text("Soy un Boton cool")
            }
        }
    }
}

@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemSelected(superHero) }
            .padding(top = 8.dp, bottom = 8.dp, end = 16.dp, start = 16.dp)) {
        Column {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superHero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 12.sp
            )
            Text(
                text = superHero.publisher, fontSize = 10.sp, modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp)
            )
        }
    }
}

fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero("Spiderman", "Peter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        SuperHero("Thor", "Thor Odison", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        SuperHero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman),
        SuperHero("Dare Devil", "Dare Davil", "DC", R.drawable.daredevil)

    )
}