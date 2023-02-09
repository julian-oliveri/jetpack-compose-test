package com.example.recipe_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.recipe_list.composable.FoodCard
import com.example.recipe_list.composable.Greeting
import com.example.recipe_list.ui.theme.MacAndCheese
import com.example.recipe_list.ui.theme.TestcomposeTheme
import com.example.recipe_list.viewmodel.ListState
import com.example.recipe_list.viewmodel.RecipeListadoViewModel
import com.example.recipe_shared_components.composable.CenterLoader


@Composable
fun RecipeListado(
    modifier: Modifier = Modifier.fillMaxSize(),
    navController: NavController,
    viewModel: RecipeListadoViewModel,
) {
//    var myFoodlist: MutableList<RecipeList> by rememberSaveable  { mutableStateOf(foodList) }
    // TODO: no deberia tener "mutables" como valor observado, "side effects"
    val state by viewModel.recipeList.observeAsState(ListState.Loading)

    when (state) {
        is ListState.Loading -> CenterLoader()
        is ListState.Loaded -> LazyColumn(state = rememberLazyListState()) {
            item {
                Greeting("Giuseppe")
            }
            items(items = (state as ListState.Loaded).list) { food ->
                FoodCard(food = food.recipe, navController)
            }
        }
        is ListState.Error -> {}
    }

    /*Surface(
        modifier = modifier,
        color = MacAndCheese
    ) {
        if (myfoodList.isEmpty()) {
            CenterLoader()
        } else {
            LazyColumn(state = rememberLazyListState()) {
                item {
                    Greeting("Giuseppe")
                }
                items(items = myfoodList.toList()) { food ->
                    FoodCard(food = food.recipe, navController)
                }
            }
        }
    }*/
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestcomposeTheme {
        Greeting("Android") // TODO: remover componentes y codigo sin utilizar
    }
}

