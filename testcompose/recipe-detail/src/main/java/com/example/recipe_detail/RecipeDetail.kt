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
import androidx.lifecycle.asLiveData
import androidx.navigation.NavController
import com.example.recipe_detail.composable.DetailScreen
import com.example.recipe_detail.ui.theme.MacAndCheese
import com.example.recipe_detail.viewmodel.RecipeDetailState
import com.example.recipe_detail.viewmodel.RecipeDetailViewModel
import com.example.recipe_detail.viewmodel.RecipeDetailViewModelFlow
import com.example.recipe_shared_components.composable.CenterLoader
import com.example.recipeappdata.model.RecipeData

@Composable
fun RecipeDetail(
    modifier: Modifier = Modifier.fillMaxSize(),
    viewModel: RecipeDetailViewModelFlow,
) {
    val state by viewModel.recipe.asLiveData().observeAsState(RecipeDetailState.Loading)

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