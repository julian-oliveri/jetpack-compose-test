package com.example.recipe_detail.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InstructionsList(
    instruction: List<String>
) {
    Column(modifier = Modifier.fillMaxWidth().padding(0.dp, 25.dp, 0.dp, 0.dp), horizontalAlignment = Alignment.CenterHorizontally){
        for (inst in instruction) {
            Text(text = inst, fontSize = 30.sp)
        }
    }
}