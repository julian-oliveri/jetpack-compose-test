package com.example.recipe_detail.viewmodel

import com.example.recipeappdata.model.RecipeData


interface RecipeDetailState {

    object Loading: RecipeDetailState

    data class Loaded(val recipe: RecipeData): RecipeDetailState

    data class Error(val error: String): RecipeDetailState

}