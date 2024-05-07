package com.example.samplenav

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.samplenav.ui.theme.SampleNavTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {// cuadrilla de items del Drawer
                NavigationDrawerItem(
                    label = {
                        Text(text = "Página 1")
                    },
                    selected = currentRoute == "page1",
                    onClick = {
                        navController.navigate("page1")
                        // drawerState.close() -- no se puede acá porque tiene que ser en otro thread (coroutine):
                        coroutineScope.launch{drawerState.close()}
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text(text = "Página 2")
                    },
                    selected = currentRoute == "page2",
                    onClick = {
                        navController.navigate("page2")
                        coroutineScope.launch{drawerState.close()}
                    }
                )
            }
        },
        drawerState = drawerState // estado que indique si está abierto o cerrado
    ) {
        Scaffold(
            modifier = modifier,
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        // debería ir a otro lado...
                        navController.navigate("page2")
                    }) {
                    Icon(
                        Icons.Filled.Build,
                        contentDescription = "cualquier cosa"
                    )
                }
            },
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "topbar in construction")
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        titleContentColor = MaterialTheme.colorScheme.primary,
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    ),
                    navigationIcon = { // hamburg menu:
                        IconButton(
                            onClick = {
                                navController.navigate("page2")
                                coroutineScope.launch { drawerState.close() }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "menu hamburg"
                            )
                        }
                    }
                )
            }
        ) {
            NavHost(
                navController = navController,
                modifier = Modifier.padding(it), // se le agrega el modifier que viene de Scaffold. "it" es el padding que pasa Scaffold cuando se construye (para no tapar el resto)
                startDestination = "page1"
            ){
                // registrar pantallas a las que podemos navegar
                composable("page1"){ Page1(navController = navController)}
                composable("page2"){ Page2(navController = navController)}
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleNavTheme {
        MainPage()
    }
}