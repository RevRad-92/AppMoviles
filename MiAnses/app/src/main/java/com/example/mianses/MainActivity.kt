package com.example.mianses

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mianses.ui.theme.MiAnsesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiAnsesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MiAnsesView("Android")
                }
            }
        }
    }
}

@Composable
fun MiAnsesView(name: String, modifier: Modifier = Modifier) {
    Column(modifier.padding(horizontal = 30.dp)) {
        Text(
            text = "Hola Juan Carlos",
            modifier = modifier.padding(vertical = 10.dp)
        )
        Row(modifier.padding()) {
            Text(
                text = "Ingresá a tu cuenta",
                modifier = modifier
            )
            Spacer(modifier = modifier.weight(1f)) // ocupa todo lo que puede ocupar
            Text(
                text = "Cambiar usuario",
                modifier = modifier
            )
        }
        TextField(value = "Clave", onValueChange = {}, modifier = modifier
            .padding(top = 10.dp)
            .fillMaxWidth(1f))
        Button(onClick = {  }, modifier = modifier
            .align(Alignment.CenterHorizontally)
            .padding(10.dp)) {
            Text(
                text = "Ingresar",
                modifier = modifier.padding(horizontal = 20.dp)
            )
        }
        Text(
            text = "Olvidé mi clave",
            modifier = modifier.align(Alignment.CenterHorizontally),
        )
        Divider(modifier.padding(vertical = 30.dp),thickness = 2.dp, color = Color.Black)
        Text(
            text = "Usa tu huella digital",
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = modifier.height(20.dp))
        Icon(
            imageVector = Icons.Rounded.AccountCircle,
            contentDescription = "huella",
            modifier = modifier.align(Alignment.CenterHorizontally).size(80.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiAnsesTheme {
        MiAnsesView("Android")
    }
}