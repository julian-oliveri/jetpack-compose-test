package com.example.recipe_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    recipeListViewModel: RecipeListadoViewModel?,
    recipeDetailViewModel: RecipeDetailViewModel?,
) {
    val navController = rememberNavController()

    val foodList: MutableList<RecipeList>? = recipeListViewModel?.recipeList?.value
    val foodItem: RecipeData? = recipeDetailViewModel?.recipe?.value

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
//        composable("onboarding") {
//            MainScreen(navController = navController)
//        }
        composable("listado") {
            RecipeListado(navController = navController, viewModel = recipeListViewModel, foodList = foodList!!)
        }

        composable("detalle/{recipeId}", arguments = listOf(navArgument("recipeId") { type = NavType.StringType }))
        {
            backStackEntry -> RecipeDetail(recipeId = backStackEntry.arguments?.getString("recipeId"), viewModel = recipeDetailViewModel, foodItem = foodItem!!)
        }

    }
}
