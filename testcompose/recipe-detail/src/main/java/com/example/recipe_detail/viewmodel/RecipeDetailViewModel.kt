package com.example.recipe_detail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe_domain.GetRecipeByIdUseCase
import com.example.recipeappdata.Model.RecipeData
import com.example.recipeappdata.Model.RecipeList
import kotlinx.coroutines.launch

class RecipeDetailViewModel(private val getRecipeUseCase: GetRecipeByIdUseCase) : ViewModel() {

    private val _recipe = MutableLiveData<RecipeData>()
    val recipe: MutableLiveData<RecipeData>
        get() = _recipe

    fun fetchRecipeId(id: String) {
        viewModelScope.launch {
            _recipe.value = getRecipeUseCase(id)!!
        }
    }

}