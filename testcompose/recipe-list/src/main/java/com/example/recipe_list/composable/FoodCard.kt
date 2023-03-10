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
import androidx.navigation.NavHostController
import com.example.recipe_list.ui.theme.CardBkg
import com.example.recipeappdata.model.RecipeData
import kotlin.reflect.KFunction2

@Composable
fun FoodCard(food: RecipeData, navController: NavController, onClickNav: KFunction2<String, NavController, Unit>) {
    var expanded by rememberSaveable { mutableStateOf(false) }

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
                    onClick = { onClickNav(food.extId, navController) },
                ) {
                    Text("Vamos Alla")
                }
            }
        }
    }
}