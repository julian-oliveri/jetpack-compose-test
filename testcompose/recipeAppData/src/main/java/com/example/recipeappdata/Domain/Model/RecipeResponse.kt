package com.example.recipeappdata.Domain.Model

data class RecipeResponse(
    val count: Int,
    val hits: MutableList<RecipeList>,
)