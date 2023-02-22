package com.example.recipe_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.recipe_list.composable.FoodCard
import com.example.recipe_list.composable.Greeting
import com.example.recipe_list.ui.theme.TestcomposeTheme
import com.example.recipe_list.viewmodel.RecipeListState
import com.example.recipe_list.viewmodel.RecipeListadoViewModel
import com.example.recipe_list.viewmodel.RecipeListadoViewModelFlow
import com.example.recipe_shared_components.composable.CenterLoader
import kotlinx.coroutines.flow.stateIn
import kotlin.reflect.KFunction2


@Composable
fun RecipeListado(
    modifier: Modifier = Modifier.fillMaxSize(),
    navController: NavController,
    viewModel: RecipeListadoViewModelFlow,
    onClickNav: KFunction2<String, NavController, Unit>
) {

    val state by viewModel.recipeList.collectAsState()
    when (state) {
        is RecipeListState.Loading -> CenterLoader()
        is RecipeListState.Loaded -> LazyColumn(state = rememberLazyListState()) {
            item {
                Greeting("Giuseppe")
            }
            items(items = (state as RecipeListState.Loaded).list) { food ->
                FoodCard(food = food.recipe, navController, onClickNav)
            }
        }
        is RecipeListState.Error -> {}
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestcomposeTheme {
        Greeting("Android") // TODO: remover componentes y codigo sin utilizar
    }
}

