package com.example.recipe_domain

import com.example.recipeappdata.Model.RecipeResponse
import com.example.recipeappdata.RecipesRepository
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(private val repository: RecipesRepository) {
    suspend operator fun invoke(): RecipeResponse? { // TODO: prestar atención a los tipos nulleables. Preferentemente evitarlos.
        return repository.getRecipes()
    }
}