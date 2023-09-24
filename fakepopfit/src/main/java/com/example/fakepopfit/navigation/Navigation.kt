package com.example.fakepopfit.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fakepopfit.presenter.AddExercise
import com.example.fakepopfit.presenter.MainScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationScreens.MAIN_FITNESS_LIST) {
        composable(NavigationScreens.MAIN_FITNESS_LIST) {
            MainScreen(navController = navController)
        }
        composable(NavigationScreens.ADD_EXERCISE) {
            AddExercise(navController = navController)
        }
    }
}