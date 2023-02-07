package com.example.recipe_domain

import com.example.recipeappdata.Model.RecipeResponse
import com.example.recipeappdata.RecipesRepository

class GetRecipesUseCase(private val repository: RecipesRepository) {
    suspend operator fun invoke(): RecipeResponse? {
        return repository.getRecipesList()
    }
}