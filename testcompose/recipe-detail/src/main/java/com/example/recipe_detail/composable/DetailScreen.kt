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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.recipe_shared_components.composable.CenterLoader
import com.example.recipeappdata.model.RecipeData

@Composable
fun DetailScreen(foodItem: RecipeData) {
    Column( modifier = Modifier.fillMaxSize()) {
            Text(
                text = foodItem.label,
                modifier = Modifier
                    .padding(10.dp, 10.dp)
                    .fillMaxWidth(),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            SubcomposeAsyncImage(
                modifier= Modifier
                    .fillMaxWidth().aspectRatio(1f),
                contentScale = ContentScale.FillBounds,
                loading = {
                    CenterLoader()
                },
                model = foodItem.image,
                contentDescription = foodItem.label
            )
        }
            IngredientsList(ingredients = foodItem.ingredients)
            Spacer(modifier = Modifier.size(30.dp))
    }
//            InstructionsList(instruction = myFoodItem.value.instructions!!)
