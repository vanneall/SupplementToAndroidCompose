package com.example.fakepopfit.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.fakepopfit.data.Exercise
import com.example.fakepopfit.presenter.add_screen.AddExerciseScreen
import com.example.fakepopfit.presenter.add_screen.AddExerciseViewModel
import com.example.fakepopfit.presenter.fruit_screen.Food
import com.example.fakepopfit.presenter.fruit_screen.FruitViewModel
import com.example.fakepopfit.presenter.image_screen.ImageScreen
import com.example.fakepopfit.presenter.image_screen.ImageScreenViewModel
import com.example.fakepopfit.presenter.info_screen.ExerciseInfoScreen
import com.example.fakepopfit.presenter.info_screen.InfoViewModel
import com.example.fakepopfit.presenter.main_screen.MainScreen
import com.example.fakepopfit.presenter.main_screen.MainScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(
    navController: NavHostController,
    actionBarTitle: MutableState<String>,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = NavigationScreens.MAIN_FITNESS_LIST) {
        composable(NavigationScreens.MAIN_FITNESS_LIST) {
            val viewModel: MainScreenViewModel = hiltViewModel()
            actionBarTitle.value = "Упражнения"
            MainScreen(
                list = viewModel.getAllExercise().observeAsState(initial = listOf<Exercise>()),
                navigate = { navController.navigate(NavigationScreens.ADD_EXERCISE) },
                openScreen = { id -> navController.navigate(NavigationScreens.EXERCISE_INFO + "/$id") }
            )
        }

        composable(NavigationScreens.ADD_EXERCISE) {
            val viewModel: AddExerciseViewModel = hiltViewModel()
            actionBarTitle.value = "Добавить упражнение"
            AddExerciseScreen(
                viewModel = viewModel,
                navigateBack = { navController.popBackStack() })
        }

        composable(NavigationScreens.FRUIT_LIST) {
            val viewModel: FruitViewModel = hiltViewModel()
            actionBarTitle.value = "БЖУ"
            Food(
                viewModel = viewModel,
            )
        }

        composable(NavigationScreens.IMAGE) {
            val viewModel: ImageScreenViewModel = hiltViewModel()
            actionBarTitle.value = "Картинка"
            ImageScreen(
                imageScreenViewModel = viewModel,
            )
        }

        composable(
            route = NavigationScreens.EXERCISE_INFO + "/{id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.StringType
                }
            )
        ) {
            val viewModel: InfoViewModel = hiltViewModel()
            actionBarTitle.value = "Информация"
            ExerciseInfoScreen(
                id = it.arguments?.getString("id") ?: "",
                viewModel = viewModel,
                navigateBack = { navController.popBackStack() })
        }
    }
}