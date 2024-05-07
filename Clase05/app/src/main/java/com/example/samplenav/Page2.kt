package com.example.samplenav

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.samplenav.ui.theme.SampleNavTheme

@Composable
fun Page2(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(modifier = modifier) {
        Text(text = "page 2")
        Button(
            onClick = {
                navController.navigate("page1")
            }
        ) {
            Text(text = "Ir a page 1")
        }
    }
}



    @Preview(showBackground = true)
@Composable
fun Page2Preview() {
    SampleNavTheme {
        val navController = rememberNavController()
        Page2(navController = navController)
    }
}