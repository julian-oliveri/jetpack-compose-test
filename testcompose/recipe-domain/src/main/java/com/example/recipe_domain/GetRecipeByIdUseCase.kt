package com.example.recipe_domain

import com.example.recipeappdata.Model.RecipeData
import com.example.recipeappdata.Model.RecipeResponse
import com.example.recipeappdata.RecipesRepository

class GetRecipeByIdUseCase(private val repository: RecipesRepository) {
    suspend operator fun invoke(id: String): RecipeData? {
        return repository.getRecipeById(id)
    }
}