package com.example.recipe_domain

import com.example.recipeappdata.model.RecipeData
import com.example.recipeappdata.RecipesRepository
import javax.inject.Inject

class GetRecipeByIdUseCase @Inject constructor(private val repository: RecipesRepository) {
    suspend operator fun invoke(id: String): RecipeData {
        return repository.getRecipeById(id)
    }
}