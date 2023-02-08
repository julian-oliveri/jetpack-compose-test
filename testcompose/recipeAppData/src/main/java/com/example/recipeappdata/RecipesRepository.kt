package com.example.recipeappdata

import android.util.Log
import com.example.recipeappdata.Model.RecipeData
import com.example.recipeappdata.Model.RecipeResponse
import com.example.recipeappdata.Network.RecipesApiService
import javax.inject.Inject

class RecipesRepository @Inject constructor(private val api: RecipesApiService) {

    private suspend fun getRecipesList(): RecipeResponse {
        return api.getRecipesList()
    }

    private suspend fun getRecipeId(id: String): RecipeData {
        return api.getRecipesById(id)
    }

    suspend fun getRecipes(): RecipeResponse {
        return try {
            val response = getRecipesList()
            response
        } catch (exception: Exception) {
            Log.e("error getRecipes", exception.message.toString())
            throw exception
        }
    }

    suspend fun getRecipeById(id: String): RecipeData {
        return try {
            val response = getRecipeId(id)
            response
        } catch (exception: Exception) {
            Log.e("error getRecipes", exception.message.toString())
            throw exception
        }
    }
}