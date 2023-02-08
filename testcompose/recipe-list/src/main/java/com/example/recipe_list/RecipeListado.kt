package com.example.recipe_list

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipe_list.ui.theme.*
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.example.recipe_list.composable.FoodCard
import com.example.recipe_list.composable.Greeting
import com.example.recipe_list.viewmodel.RecipeListadoViewModel
import com.example.recipe_shared_components.composable.CenterLoader
import com.example.recipeappdata.Model.RecipeData
import com.example.recipeappdata.Model.RecipeList


@Composable
fun RecipeListado(
    modifier: Modifier = Modifier.fillMaxSize(),
    navController: NavController,
    viewModel: RecipeListadoViewModel,
) {
//    var myFoodlist: MutableList<RecipeList> by rememberSaveable  { mutableStateOf(foodList) }
    val myfoodList = viewModel.recipeList.observeAsState(mutableListOf())

    Surface(
        modifier = modifier,
        color = MacAndCheese
    ) {
        if (myfoodList.value.isEmpty()) {
            CenterLoader()
        } else {
            LazyColumn(state = rememberLazyListState()) {
                item {
                    Greeting("Giuseppe")
                }
                items(items = myfoodList.value.toList()) { food ->
                    FoodCard(food = food.recipe, navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestcomposeTheme {
        Greeting("Android")
    }
}

