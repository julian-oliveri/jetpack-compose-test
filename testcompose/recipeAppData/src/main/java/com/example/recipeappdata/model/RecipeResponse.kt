package com.example.recipeappdata.model

import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("hits")
    val hits: MutableList<Recipes>,
)