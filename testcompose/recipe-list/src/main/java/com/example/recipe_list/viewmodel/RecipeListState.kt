package com.example.recipe_list.viewmodel

import com.example.recipeappdata.model.Recipes

interface RecipeListState {

    object Loading: RecipeListState

    data class Loaded(val list: List<Recipes>): RecipeListState

    data class Error(val error: String): RecipeListState

}