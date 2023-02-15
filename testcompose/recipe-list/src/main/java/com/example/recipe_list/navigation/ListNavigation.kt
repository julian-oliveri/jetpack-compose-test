package com.example.recipe_list.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.recipe_list.RecipeListado
import com.example.recipe_list.viewmodel.RecipeListadoViewModel
import com.example.recipe_list.viewmodel.RecipeListadoViewModelFlow

fun navToDetail(extId: String, navController: NavController) {
    val navDestination = "detalle/$extId"
    navController.navigate(navDestination)
}

fun NavGraphBuilder.addRecipeListScreen(
    navController: NavHostController
) {
    composable("listado") {
        val recipeListViewModel: RecipeListadoViewModelFlow = hiltViewModel()

        LaunchedEffect(true) {
            recipeListViewModel.fetchRecipes()
        }
        RecipeListado(navController = navController, viewModel = recipeListViewModel, onClickNav = ::navToDetail)
    }
}
