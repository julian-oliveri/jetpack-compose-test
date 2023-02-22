package com.example.recipe_navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipe_detail.RecipeDetail
import com.example.recipe_detail.navigation.addRecipeDetailScreen
import com.example.recipe_detail.viewmodel.RecipeDetailViewModel
import com.example.recipe_list.RecipeListado
import com.example.recipe_list.navigation.addRecipeListScreen
import com.example.recipe_list.viewmodel.RecipeListadoViewModel

@Composable
fun RecipesNavigator(
    modifier: Modifier = Modifier,
    startDestination: String = "listado",
) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        // TODO generar constantes para los nombres de las rutas (o clase)
        addRecipeListScreen(
            navController
        )

        addRecipeDetailScreen()

    }
}