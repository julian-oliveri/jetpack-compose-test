package com.example.recipeappdata.Model

import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("hits")
    val hits: MutableList<RecipeList>,
)