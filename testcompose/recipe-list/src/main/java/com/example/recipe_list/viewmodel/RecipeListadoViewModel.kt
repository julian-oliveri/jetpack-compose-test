package com.example.recipe_list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe_domain.GetRecipesUseCase
import com.example.recipeappdata.Model.RecipeList
import com.example.recipeappdata.Model.RecipeResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListadoViewModel @Inject constructor(private val getRecipeUseCase: GetRecipesUseCase) : ViewModel() {

    private val _recipeList = MutableLiveData<MutableList<RecipeList>>()
    val recipeList: MutableLiveData<MutableList<RecipeList>>
        get() = _recipeList

    fun fetchRecipes() {
        viewModelScope.launch {
            _recipeList.value = getRecipeUseCase()!!.hits
        }
    }

}