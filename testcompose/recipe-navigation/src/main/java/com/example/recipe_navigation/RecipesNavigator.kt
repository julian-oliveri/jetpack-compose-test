package com.example.recipe_navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.recipe_detail.RecipeDetail
import com.example.recipe_detail.viewmodel.RecipeDetailViewModel
import com.example.recipe_list.RecipeListado
import com.example.recipe_list.viewmodel.RecipeListadoViewModel
import com.example.recipeappdata.Model.RecipeData
import com.example.recipeappdata.Model.RecipeList

@Composable
fun RecipesNavigator(
    modifier: Modifier = Modifier,
    startDestination: String = "listado",
    recipeListViewModel: RecipeListadoViewModel = hiltViewModel(),
    recipeDetailViewModel: RecipeDetailViewModel = hiltViewModel(),
) {
    val navController = rememberNavController()

//    val foodList: MutableList<RecipeList>? = recipeListViewModel.recipeList.value
//    val foodItem: RecipeData? = recipeDetailViewModel.recipe.value

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        composable("listado")
        {
            LaunchedEffect(true) {
                recipeListViewModel.fetchRecipes()
            }
            RecipeListado(navController = navController, viewModel = recipeListViewModel)
        }

        composable("detalle/{recipeId}", arguments = listOf(navArgument("recipeId") { type = NavType.StringType }))
        {
            backStackEntry ->
                val recipeId = backStackEntry.arguments?.getString("recipeId")
                LaunchedEffect(true) {
                    if (recipeId != null) {
                        recipeDetailViewModel.fetchRecipeId(recipeId)
                    }
                }
                RecipeDetail(recipeId = recipeId, viewModel = recipeDetailViewModel, navController = navController)
        }

    }
}
