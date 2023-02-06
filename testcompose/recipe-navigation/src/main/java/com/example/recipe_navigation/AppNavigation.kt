package com.example.recipe_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.recipe_detail.RecipeDetail
import com.example.recipe_list.RecipeListado

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "listado"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
//        composable("onboarding") {
//            MainScreen(navController = navController)
//        }
        composable("listado") {
            RecipeListado(navController = navController)
        }
        composable("detalle/{recipeId}", arguments = listOf(navArgument("recipeId") { type = NavType.StringType }))
        {
            backStackEntry -> RecipeDetail(backStackEntry.arguments?.getString("userId"))
        }
    }
}
