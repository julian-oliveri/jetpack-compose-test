package com.example.recipe_list.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.recipe_list.ui.theme.CardBkg
import com.example.recipeappdata.Model.RecipeData

data class A(val url: String)

data class R(val id: String)

fun A.toDomain() = R(id = url.substringAfter("recipe_"))

class UseCase {

    operator fun invoke(): List<R> {
        return emptyList<A>().map { it.toDomain() }
    }
}

@Composable
fun FoodCard(food: RecipeData, navController: NavController,) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val extId = food.uri.substringAfter("recipe_") // TODO no debería haber logica en los componentes, viewmodel/usecase/domain
    val navDestination = "detalle/$extId"
    Box( modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(CardBkg) ) {
        Column(modifier = Modifier.padding(0.dp, 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                modifier = Modifier.padding(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = food.label,
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp, 10.dp),
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                )
                ElevatedButton( // TODO caso de uso animaciones, crear un collapsable animado
                    onClick = { expanded = !expanded },
                ) {
                    Text(if (expanded) "Show less" else "Show more")
                }
            }
            if (expanded) {
                Column(modifier = Modifier.padding(horizontal = 4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    for (ing in food.ingredients) {
                        Text(ing.text, textAlign = TextAlign.Center)
                    }
                }

                ElevatedButton(
                    onClick =  {navController.navigate(navDestination)} ,
                ) {
                    Text("Vamos Alla")
                }
            }
        }
    }
}