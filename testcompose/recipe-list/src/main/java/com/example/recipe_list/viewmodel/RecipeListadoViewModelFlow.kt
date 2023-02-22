package com.example.recipe_list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe_domain.GetRecipesUseCase
import com.example.recipeappdata.model.Recipes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListadoViewModelFlow @Inject constructor(private val getRecipeUseCase: GetRecipesUseCase) : ViewModel() {

    private val _recipeList = MutableStateFlow<RecipeListState>(RecipeListState.Loading)

    val recipeList: StateFlow<RecipeListState> = _recipeList

    fun fetchRecipes() {
        viewModelScope.launch {
            _recipeList.value = RecipeListState.Loading
            try {
                _recipeList.value = RecipeListState.Loaded(getRecipeUseCase()!!.hits)
            } catch (error: java.lang.Exception) {
                _recipeList.value = RecipeListState.Error(error.message ?: "Error")
            }
        }
    }

}