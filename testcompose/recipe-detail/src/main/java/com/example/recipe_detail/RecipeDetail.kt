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
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.recipe_detail.composable.IngredientsList
import com.example.recipe_detail.composable.InstructionsList
import com.example.recipe_detail.ui.theme.MacAndCheese
import com.example.recipe_detail.ui.theme.TestcomposeTheme
import com.example.recipe_detail.viewmodel.RecipeDetailViewModel
import com.example.recipeappdata.Model.RecipeData
import com.example.recipeappdata.Model.RecipeIngredients
import com.example.recipeappdata.Model.RecipeList

@Composable
fun RecipeDetail(
    recipeId: String?,
    modifier: Modifier = Modifier.fillMaxSize(),
    viewModel: RecipeDetailViewModel,
) {
    val recipeId = recipeId ?: "nollega"
    Log.d("idLlega", recipeId)

    val myFoodItem = viewModel.recipe.observeAsState(RecipeData("", "", "", "", listOf(), listOf(), ""))


    Surface(
        modifier = modifier,
        color = MacAndCheese
    ) {
        Column() {
            Text(
                text = myFoodItem.value.label,
                modifier = Modifier
                    .padding(10.dp, 10.dp)
                    .fillMaxWidth(),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            AsyncImage(
                modifier= Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
                model = myFoodItem.value.image,
                contentDescription = "Translated description of what the image contains"
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp, 25.dp, 25.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IngredientsList(ingredients = myFoodItem.value.ingredients)
            }
//            InstructionsList(instruction = myFoodItem.value.instructions!!)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    RecipeDetail(modifier = Modifier.fillMaxSize(), recipeId = "previewRecipeId")
}

//foodItem: RecipeData = RecipeData("uri", "pasta con salsa", "https://media.istockphoto.com/id/1325172440/photo/spaghetti-alla-puttanesca-italian-pasta-dish-with-tomatoes-black-olives-capers-anchovies-and.jpg?b=1&s=170667a&w=0&k=20&c=0XEgTZ2pcp83v0rBgjtQ0bH9pXkxYDQgW7mrc5aNX30=", "url", listOf(
//RecipeIngredients("ing1", 1f, "300ml"), RecipeIngredients("ing2", 1f, "1/4 tazas"), RecipeIngredients("ing3", 1f, "3 unidades")
//),listOf("pelar ing1", "batir ing2","saltear ing3", "incorporar todo" ), "extid"),