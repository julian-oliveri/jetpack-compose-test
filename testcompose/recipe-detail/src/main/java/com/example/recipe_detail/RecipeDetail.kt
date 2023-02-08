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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
    foodItem: RecipeData = RecipeData("uri", "pasta con salsa", "https://media.istockphoto.com/id/1325172440/photo/spaghetti-alla-puttanesca-italian-pasta-dish-with-tomatoes-black-olives-capers-anchovies-and.jpg?b=1&s=170667a&w=0&k=20&c=0XEgTZ2pcp83v0rBgjtQ0bH9pXkxYDQgW7mrc5aNX30=", "url", listOf(
        RecipeIngredients("ing1", 1f, "300ml"), RecipeIngredients("ing2", 1f, "1/4 tazas"), RecipeIngredients("ing3", 1f, "3 unidades")
    ),listOf("pelar ing1", "batir ing2","saltear ing3", "incorporar todo" ), "extid"),
) {
    val recipeId = recipeId ?: "nollega"
    Log.d("idLlega", recipeId)

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchRecipeId(recipeId)
    }

    Surface(
        modifier = modifier,
        color = MacAndCheese
    ) {
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth().padding(25.dp, 25.dp, 25.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    RecipeDetail(modifier = Modifier.fillMaxSize(), recipeId = "previewRecipeId")
}