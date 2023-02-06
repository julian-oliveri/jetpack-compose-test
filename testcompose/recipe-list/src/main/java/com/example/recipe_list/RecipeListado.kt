package com.example.recipe_list

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipe_list.ui.theme.*
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.navigation.NavController
import com.example.recipeappdata.Domain.Model.RecipeData
import com.example.recipeappdata.Domain.Model.RecipeList


var foodList: MutableList<RecipeList> = mutableListOf<RecipeList>()

class RecipeListado(navController: NavController) : ComponentActivity() {
    val myNav = navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestcomposeTheme {
                MyApp(modifier = Modifier.fillMaxSize(), foodList, myNav)
            }
        }
    }
}

@Composable
private fun MyApp(
    modifier: Modifier = Modifier,
    foodList: MutableList<RecipeList>,
    navController: NavController
) {
    // el by es para no tener q escribir .value cada vez
    var myFoodlist: MutableList<RecipeList> by rememberSaveable  { mutableStateOf(foodList) }

    Surface(modifier) {
            FoodScreen(modifier, myFoodlist,  navController )
        }
}

@Composable
fun Greeting(name: String) {
    Surface( color = MacAndCheese, modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(0.dp, 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Buongiorno $name!",
                modifier = Modifier.padding(0.dp, 32.dp, 0.dp, 10.dp),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Green)) {
                        append("Qui cosa ")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = White)) {
                        append("vorresti ")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Red)) {
                        append("mangiare?")
                    }
                },
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
            )

        }
    }
}

@Composable
fun FoodCard(food: RecipeData, navController: NavController,) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val extId = food.uri
    val navDestination = "detalle/$extId"
    Box( modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(CardBkg) ) {
        Column(modifier = Modifier.padding(0.dp, 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                modifier = Modifier.padding(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = food.label,
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp, 10.dp),
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                )
                ElevatedButton(
                    onClick = { expanded = !expanded },
                ) {
                    Text(if (expanded) "Show less" else "Show more")
                }
            }
            if (expanded) {
//                AsyncImage(
//                    model = "https://example.com/image.jpg",
//                    contentDescription = "Translated description of what the image contains"
//                )
                Column(modifier = Modifier.padding(horizontal = 4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    for (ing in food.ingredients) {
                        Text(ing.text, textAlign = TextAlign.Center)
                    }
                }

                ElevatedButton(
                    onClick =  {navController.navigate(navDestination)} ,
                ) {
                    Text("Vamos Alla")
                }
            }
        }
    }
}


@Composable
private fun FoodScreen(
    modifier: Modifier = Modifier,
    foodList: MutableList<RecipeList>,
    navController: NavController
) {
    Surface(
        modifier = modifier,
        color = MacAndCheese
    ) {
        LazyColumn(state = rememberLazyListState()){
            item {
                Greeting("Giuseppe")
            }
            items(items = foodList) { food ->
                FoodCard(food = food.recipe, navController)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestcomposeTheme {
        Greeting("Android")
    }
}

