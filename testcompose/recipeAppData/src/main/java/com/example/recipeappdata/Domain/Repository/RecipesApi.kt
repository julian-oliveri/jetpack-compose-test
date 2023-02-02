package com.example.recipeappdata.Domain.Repository

import com.example.recipeappdata.Domain.Model.RecipeData
import com.example.recipeappdata.Domain.Model.RecipeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipesApi {
    companion object {
        const val myapp_id: String = "aa59c605"
        const val myapp_key = "98b7a5c2359dc7a0e0964db1e39f191d"
    }

    @GET("/api/recipes/v2")
    suspend fun getRecipes(@Query("type") type: String = "public", @Query("cuisineType") cuisineType: String = "italian", @Query("app_id") app_id: String = myapp_id, @Query("app_key") app_key: String = myapp_key) : Response<RecipeResponse>

    @GET("/api/recipes/v2/{id}")
    suspend fun getRecipeById(@Path("id") id: String, @Query("type") type: String = "public", @Query("app_id") app_id: String = myapp_id, @Query("app_key") app_key: String = myapp_key) : Response<RecipeData>

}