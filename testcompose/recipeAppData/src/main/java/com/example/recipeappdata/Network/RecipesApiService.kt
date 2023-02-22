package com.example.recipeappdata.Network

import com.example.recipeappdata.model.RecipeData
import com.example.recipeappdata.model.Recipes
import com.example.recipeappdata.model.RecipeResponse
import com.example.recipeappdata.model.toExtId
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RecipesApiService @Inject constructor(private val apiClient: RecipesApiClient) {

    suspend fun getRecipesList(): RecipeResponse {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getRecipes().body()?: RecipeResponse(0, mutableListOf())
            RecipeResponse(response.count, response.hits)
        }
    }

    suspend fun getRecipesById(id: String): RecipeData {
        return withContext(Dispatchers.IO) {
//            val response = apiClient.getRecipeById(id).body()?: RecipeData("", "","","", listOf(),  listOf(), "" )
            val response = apiClient.getRecipeById(id).body()?: Recipes(RecipeData("", "","","", listOf(),  listOf(), "" ))

            response.recipe.toExtId()
        }
    }
}