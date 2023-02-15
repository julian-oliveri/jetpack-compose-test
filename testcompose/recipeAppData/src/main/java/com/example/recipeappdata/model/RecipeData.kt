package com.example.recipeappdata.model

import com.google.gson.annotations.SerializedName

data class RecipeData (
    @SerializedName("uri")
    val uri: String,
    @SerializedName("label")
    val label: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("ingredients")
    val ingredients: List<RecipeIngredients>,
    @SerializedName("instructions")
    val instructions: List<String>?,
    val extId: String
)

fun RecipeData.toDomain() = RecipeData(uri, label, image, url, ingredients, instructions, uri.substringAfter("recipe_"))
