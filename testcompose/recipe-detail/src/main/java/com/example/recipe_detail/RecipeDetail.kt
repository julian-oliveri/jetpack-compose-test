package com.example.recipe_detail

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.recipe_detail.composable.DetailScreen
import com.example.recipe_detail.ui.theme.MacAndCheese
import com.example.recipe_detail.viewmodel.RecipeDetailState
import com.example.recipe_detail.viewmodel.RecipeDetailViewModel
import com.example.recipe_shared_components.composable.CenterLoader
import com.example.recipeappdata.model.RecipeData

@Composable
fun RecipeDetail(
    modifier: Modifier = Modifier.fillMaxSize(),
    viewModel: RecipeDetailViewModel,
) {
    val state by viewModel.recipe.observeAsState(RecipeDetailState.Loading)

    when (state) {
        is RecipeDetailState.Loading -> CenterLoader()
        is RecipeDetailState.Loaded -> LazyColumn(state = rememberLazyListState()) {
            item {
                DetailScreen(foodItem = (state as RecipeDetailState.Loaded).recipe)
            }
        }
        is RecipeDetailState.Error -> {}
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    // TODO: implementar, tuviste alguna dificultad?
    // RecipeDetail(modifier = Modifier.fillMaxSize(), recipeId = "previewRecipeId")
}

//foodItem: RecipeData = RecipeData("uri", "pasta con salsa", "https://media.istockphoto.com/id/1325172440/photo/spaghetti-alla-puttanesca-italian-pasta-dish-with-tomatoes-black-olives-capers-anchovies-and.jpg?b=1&s=170667a&w=0&k=20&c=0XEgTZ2pcp83v0rBgjtQ0bH9pXkxYDQgW7mrc5aNX30=", "url", listOf(
//RecipeIngredients("ing1", 1f, "300ml"), RecipeIngredients("ing2", 1f, "1/4 tazas"), RecipeIngredients("ing3", 1f, "3 unidades")
//),listOf("pelar ing1", "batir ing2","saltear ing3", "incorporar todo" ), "extid"),