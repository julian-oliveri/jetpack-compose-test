package com.example.testcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcompose.ui.theme.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.recipe_detail.viewmodel.RecipeDetailViewModel
import com.example.recipe_list.viewmodel.RecipeListadoViewModel
import com.example.recipe_navigation.RecipesNavigator

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TestcomposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    RecipesNavigator()
                }
            }
        }
    }
}

@Composable
private fun MyApp(
    modifier: Modifier = Modifier,
) {
    // el by es para no tener q escribir .value cada vez
    var shouldShowOnboarding by rememberSaveable  { mutableStateOf(true) }

    Surface(modifier) {
        OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
    }

}

@Preview
@Composable
fun MyAppPreview() {
    TestcomposeTheme {
        MyApp(Modifier.fillMaxSize())
    }
}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Benvenuti in cucina!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    TestcomposeTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestcomposeTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}

//        val recipesApi = RetrofitHelper.getInstance().create(RecipesApi::class.java)
//        GlobalScope.launch {
//            val result = recipesApi.getRecipes()
//            Log.d("food", result.body()!!.hits[1].recipe.toString())
//            if (result != null)
//                foodList?.let { list1 -> result.body()!!.hits?.let(list1::addAll) }
//
//        }