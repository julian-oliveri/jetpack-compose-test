package com.example.recipe_detail

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.recipe_detail.ui.theme.MacAndCheese
import com.example.recipe_detail.ui.theme.TestcomposeTheme
import com.example.recipeappdata.Model.RecipeData
import com.example.recipeappdata.Model.RecipeIngredients
import com.example.recipeappdata.Model.RecipeList

class RecipeDetail(recipeId: String?) : ComponentActivity() {
    val recipeId = recipeId ?: "nollega"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("idLlega", recipeId)

        setContent {
            TestcomposeTheme {
                // A surface container using the 'background' color from the theme
                    MyApp(modifier = Modifier.fillMaxSize() )
            }
        }
    }
}

@Composable
private fun MyApp(
    modifier: Modifier = Modifier,
) {
    Surface(modifier) {
        RecipeDetail(modifier)
    }
}

@Composable
fun RecipeDetail(
    modifier: Modifier = Modifier,
    foodItem: RecipeData = RecipeData("uri", "pasta con salsa", "https://media.istockphoto.com/id/1325172440/photo/spaghetti-alla-puttanesca-italian-pasta-dish-with-tomatoes-black-olives-capers-anchovies-and.jpg?b=1&s=170667a&w=0&k=20&c=0XEgTZ2pcp83v0rBgjtQ0bH9pXkxYDQgW7mrc5aNX30=", "url", listOf(
        RecipeIngredients("ing1", 1f, "300ml"), RecipeIngredients("ing2", 1f, "1/4 tazas"), RecipeIngredients("ing3", 1f, "3 unidades")
    ),listOf("pelar ing1", "batir ing2","saltear ing3", "incorporar todo" ), "extid"),
) {
    Surface(
        modifier = modifier,
        color = MacAndCheese
    ) {
        Column(){
            Row(modifier = Modifier.fillMaxWidth().padding(25.dp, 25.dp, 25.dp, 0.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                IngredientsList(ingredients = foodItem.ingredients)
                AsyncImage(
                    model = foodItem.image,
                    contentDescription = "Translated description of what the image contains"
                )
            }
            InstructionsList(instruction = foodItem.instructions)
        }

    }
}

@Composable
fun IngredientsList(
    modifier: Modifier = Modifier,
    ingredients: List<RecipeIngredients>,
) {
    Column(){
        for (ing in ingredients) {
            Text(text = "- " + ing.text, fontWeight = FontWeight.Bold, fontSize = 24.sp)
        }
    }
}

@Composable
fun InstructionsList(
    modifier: Modifier = Modifier,
    instruction: List<String>
) {
    Column(modifier = Modifier.fillMaxWidth().padding(0.dp, 25.dp, 0.dp, 0.dp), horizontalAlignment = Alignment.CenterHorizontally){
        for (inst in instruction) {
            Text(text = inst, fontSize = 30.sp)
        }
    }
}


@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun RecipeDetailPreview() {
    TestcomposeTheme {
        RecipeDetail(modifier = Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestcomposeTheme {
        RecipeDetail(modifier = Modifier.fillMaxSize())
    }
}