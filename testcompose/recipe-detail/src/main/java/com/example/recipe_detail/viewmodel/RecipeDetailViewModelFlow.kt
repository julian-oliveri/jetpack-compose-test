package com.example.recipe_detail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe_domain.GetRecipeByIdUseCase
import com.example.recipeappdata.model.RecipeData
import com.example.recipeappdata.model.Recipes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModelFlow @Inject constructor(private val getRecipeUseCase: GetRecipeByIdUseCase) : ViewModel() {

    private val _recipe = MutableStateFlow<RecipeDetailState>(RecipeDetailState.Loading)

    val recipe: StateFlow<RecipeDetailState> = _recipe

    fun fetchRecipeId(id: String) {
        viewModelScope.launch {
            _recipe.value = RecipeDetailState.Loading
            try {
                _recipe.value = RecipeDetailState.Loaded(getRecipeUseCase(id))
            } catch (error: java.lang.Exception) {
                _recipe.value = RecipeDetailState.Error(error.message ?: "Error")
            }
        }
    }

}