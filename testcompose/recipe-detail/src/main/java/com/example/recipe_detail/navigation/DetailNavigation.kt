package com.example.recipe_detail.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.recipe_detail.RecipeDetail
import com.example.recipe_detail.viewmodel.RecipeDetailViewModel
import com.example.recipe_detail.viewmodel.RecipeDetailViewModelFlow

fun NavGraphBuilder.addRecipeDetailScreen() {
    composable("detalle/{recipeId}", arguments = listOf(navArgument("recipeId") { type = NavType.StringType }))
    { backStackEntry ->
        val recipeDetailViewModel: RecipeDetailViewModelFlow = hiltViewModel()
        val recipeId = backStackEntry.arguments?.getString("recipeId")
        LaunchedEffect(true) {
            if (recipeId != null) {
                recipeDetailViewModel.fetchRecipeId(recipeId)
            }
        }
        RecipeDetail(viewModel = recipeDetailViewModel)
    }
}