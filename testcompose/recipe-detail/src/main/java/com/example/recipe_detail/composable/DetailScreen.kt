package com.example.recipe_detail.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.example.recipe_shared_components.composable.CenterLoader
import com.example.recipeappdata.Model.RecipeData

@Composable
fun DetailScreen(foodItem: State<RecipeData>) {

    Column() {
        Text(
            text = foodItem.value.label,
            modifier = Modifier
                .padding(10.dp, 10.dp)
                .fillMaxWidth(),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        SubcomposeAsyncImage(
            modifier= Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
            loading = {
                CenterLoader()
            },
            model = foodItem.value.image,
            contentDescription = "Translated description of what the image contains"
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp, 25.dp, 25.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IngredientsList(ingredients = foodItem.value.ingredients)
        }
//            InstructionsList(instruction = myFoodItem.value.instructions!!)
    }
}