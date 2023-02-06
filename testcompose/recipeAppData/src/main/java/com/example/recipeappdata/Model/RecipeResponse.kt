package com.example.recipeappdata.Model

data class RecipeResponse(
    val count: Int,
    val hits: MutableList<RecipeList>,
)