package com.example.recipe_list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe_domain.GetRecipesUseCase
import com.example.recipeappdata.model.Recipes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListadoViewModel @Inject constructor(private val getRecipeUseCase: GetRecipesUseCase) : ViewModel() {

    private val _recipeList = MutableLiveData<RecipeListState>(RecipeListState.Loading)

    val recipeList: LiveData<RecipeListState> = _recipeList

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