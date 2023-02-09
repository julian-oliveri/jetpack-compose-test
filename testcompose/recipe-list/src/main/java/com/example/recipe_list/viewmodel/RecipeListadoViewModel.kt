package com.example.recipe_list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe_domain.GetRecipesUseCase
import com.example.recipeappdata.Model.RecipeList
import com.example.recipeappdata.Model.RecipeResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

interface ListState {

    object Loading: ListState

    data class Loaded(val list: List<RecipeList>): ListState

    data class Error(val error: String): ListState

}

@HiltViewModel
class RecipeListadoViewModel @Inject constructor(private val getRecipeUseCase: GetRecipesUseCase) : ViewModel() {

    private val _recipeList = MutableLiveData<ListState>(ListState.Loading)

    val recipeList: LiveData<ListState> = _recipeList

    fun fetchRecipes() {
        viewModelScope.launch {
            _recipeList.value = ListState.Loading
            try {
                _recipeList.value = ListState.Loaded(getRecipeUseCase()!!.hits)
            } catch (error: java.lang.Exception) {
                _recipeList.value = ListState.Error(error.message ?: "Error")
            }
        }
    }

}