package com.example.recipe_detail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe_domain.GetRecipeByIdUseCase
import com.example.recipeappdata.Model.RecipeData
import com.example.recipeappdata.Model.RecipeList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// TODO: probar con flow (opcional)
// TODO: podemos probar armado una clase que represente un estado

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(private val getRecipeUseCase: GetRecipeByIdUseCase) : ViewModel() {

    private val _recipe = MutableLiveData<RecipeData>()

    val recipe: LiveData<RecipeData> = _recipe

    fun fetchRecipeId(id: String) {
        viewModelScope.launch {
            _recipe.value = getRecipeUseCase(id)!!
        }
    }

    fun emptyRecipe() {
        viewModelScope.launch {
            _recipe.value = RecipeData("", "", "", "", listOf(), listOf(), "" )
        }
    }

}