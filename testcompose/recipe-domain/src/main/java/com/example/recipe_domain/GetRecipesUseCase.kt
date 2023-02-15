package com.example.recipe_domain

import com.example.recipeappdata.model.RecipeResponse
import com.example.recipeappdata.RecipesRepository
import com.example.recipeappdata.model.RecipeData
import com.example.recipeappdata.model.Recipes
import com.example.recipeappdata.model.toDomain
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(private val repository: RecipesRepository) {
    suspend operator fun invoke(): RecipeResponse {
        val recipes = repository.getRecipes()
        var recHits: MutableList<Recipes> = mutableListOf()
        recipes.hits.map {
            recHits.add(
                Recipes(
                    it.recipe.toDomain()
                )
            )
        }

        return RecipeResponse(recipes.count, recHits)
    }
}