package com.example.recipeappdata.Network

import com.example.recipeappdata.BuildConfig
import com.example.recipeappdata.model.Recipes
import com.example.recipeappdata.model.RecipeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipesApiClient {
    companion object {
        const val myapp_id = com.example.recipeappdata.BuildConfig.APP_ID
        const val myapp_key = com.example.recipeappdata.BuildConfig.APP_KEY
    }

    @GET("/api/recipes/v2")
    suspend fun getRecipes(@Query("type") type: String = "public", @Query("cuisineType") cuisineType: String = "italian", @Query("app_id") app_id: String = myapp_id, @Query("app_key") app_key: String = myapp_key) : Response<RecipeResponse>

    @GET("/api/recipes/v2/{id}")
    suspend fun getRecipeById(@Path("id") id: String, @Query("type") type: String = "public", @Query("app_id") app_id: String = myapp_id, @Query("app_key") app_key: String = myapp_key) : Response<Recipes>

}