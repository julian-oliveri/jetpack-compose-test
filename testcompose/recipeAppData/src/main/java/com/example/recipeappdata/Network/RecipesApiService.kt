package com.example.recipeappdata.Network

import com.example.recipeappdata.Model.RecipeData
import com.example.recipeappdata.Model.RecipeList
import com.example.recipeappdata.Model.RecipeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipesApiService(private val apiClient: RecipesApiClient) {

    suspend fun getRecipesList(): RecipeResponse {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getRecipes().body()?: RecipeResponse(0, mutableListOf())
            RecipeResponse(response.count, response.hits)
        }
    }

    suspend fun getRecipesById(id: String): RecipeData {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getRecipeById(id).body()?: RecipeData("", "","","", listOf(),  listOf(), "" )
            RecipeData(response.uri, response.label, response.image, response.url, response.ingredients, response.instructions, response.externalId )
        }
    }
}