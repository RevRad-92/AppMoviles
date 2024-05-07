package com.example.primerapruebacomposer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Login(usuario: String) {
    Column{
        Spacer(modifier = Modifier.height(20.dp))
        Text("Login")
        Text("$usuario elegi con que queres logearte")
        Spacer(modifier = Modifier.height(20.dp))
        Divider()
        Spacer(modifier = Modifier.height(20.dp))
        Column {
            botonera()
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun botonera(){

    Button(onClick = {}, content = { Text("Login con adasd") })
}


@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun Preview() {

        Login("Carlos")
    }