package com.example.recipe_detail.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.recipeappdata.model.RecipeIngredients

@Composable
fun IngredientsList(
    ingredients: List<RecipeIngredients>,
) {
    Column(){
        for (ing in ingredients) {
            Text(text = "- " + ing.text, fontWeight = FontWeight.Bold, fontSize = 24.sp)
        }
    }
}