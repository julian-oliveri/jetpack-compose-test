package com.example.recipe_detail.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
    LazyColumn(state = rememberLazyListState(), modifier = Modifier.fillMaxSize()) {
        item {
            Text(
                text = foodItem.value.label,
                modifier = Modifier
                    .padding(10.dp, 10.dp)
                    .fillMaxWidth(),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }
        item {
            SubcomposeAsyncImage(
                modifier= Modifier
                    .fillMaxWidth().aspectRatio(1f),
                contentScale = ContentScale.FillBounds,
                loading = {
                    CenterLoader()
                },
                model = foodItem.value.image,
                contentDescription = foodItem.value.label
            )
        }
        item {
            IngredientsList(ingredients = foodItem.value.ingredients)
            Spacer(modifier = Modifier.size(30.dp))
        }
    }
//            InstructionsList(instruction = myFoodItem.value.instructions!!)
}