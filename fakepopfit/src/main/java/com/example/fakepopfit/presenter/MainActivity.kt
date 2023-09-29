package com.example.fakepopfit.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fakepopfit.navigation.Navigation
import com.example.fakepopfit.navigation.NavigationScreens
import com.example.fakepopfit.ui.theme.SupplementToAndroidComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SupplementToAndroidComposeTheme {
                val navController = rememberNavController()
                var actionBarTitle = rememberSaveable { mutableStateOf("Упражнения") }
                navController.currentDestination?.route = "Главная"
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(title = {
                            Text(
                                text = actionBarTitle.value,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 10.dp)
                            )
                        })
                    },
                    bottomBar = {
                        MyBottomNavigation(
                            navController = navController,
                            screens = listOf(
                                Item(
                                    "Главная",
                                    NavigationScreens.MAIN_FITNESS_LIST,
                                ),
                                Item(
                                    "БЖУ",
                                    NavigationScreens.FRUIT_LIST,
                                ),
                                Item(
                                    "Картинка",
                                    NavigationScreens.IMAGE,
                                )
                            )
                        )
                    }) { innerPadding ->
                    Navigation(
                        navController = navController,
                        actionBarTitle = actionBarTitle,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyBottomNavigation(
    navController: NavController,
    screens: List<Item>
) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        screens.forEach { screen ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { ScreenIcon(screen.name) },
            )
        }
    }
}


data class Item(val name: String, val route: String)

@Composable
fun ScreenIcon(name: String) {
    Box(modifier = Modifier, contentAlignment = Alignment.Center) {
        Text(text = name)
    }
}

@Composable
fun getScreenTitle(route: String): String {
    return when (route) {
        NavigationScreens.MAIN_FITNESS_LIST -> "Упражнения"
        NavigationScreens.ADD_EXERCISE -> "Добавить упражнение"
        else -> "Unknown"
    }
}