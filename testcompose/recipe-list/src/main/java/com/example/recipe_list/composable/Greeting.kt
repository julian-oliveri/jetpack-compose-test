package com.example.recipe_list.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipe_list.ui.theme.Green
import com.example.recipe_list.ui.theme.MacAndCheese
import com.example.recipe_list.ui.theme.Red
import com.example.recipe_list.ui.theme.White

@Composable
fun Greeting(name: String) {
    Surface( color = MacAndCheese, modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(0.dp, 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Buongiorno $name!",
                modifier = Modifier.padding(0.dp, 32.dp, 0.dp, 10.dp),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Green)) {
                        append("Qui cosa ")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = White)) {
                        append("vorresti ")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Red)) {
                        append("mangiare?")
                    }
                },
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
            )

        }
    }
}