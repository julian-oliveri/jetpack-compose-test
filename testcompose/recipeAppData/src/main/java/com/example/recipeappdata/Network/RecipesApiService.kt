package com.example.recipeappdata.Network

import com.example.recipeappdata.Model.RecipeData
import com.example.recipeappdata.Model.RecipeList
import com.example.recipeappdata.Model.RecipeResponse
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
            val response = apiClient.getRecipeById(id).body()?: RecipeList(RecipeData("", "","","", listOf(),  listOf(), "" ))

            RecipeData(response.recipe.uri, response.recipe.label, response.recipe.image, response.recipe.url, response.recipe.ingredients, response.recipe.instructions, response.recipe.externalId )
        }
    }
}