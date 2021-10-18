package com.mumti.fureeapplication.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.mumti.fureeapplication.view.DetailScreen
import com.mumti.fureeapplication.view.GetStartedScreen
import com.mumti.fureeapplication.view.HomeScreen
import com.mumti.fureeapplication.viewmodel.MainViewModel

object EndPoints {
    const val NAME = "name"
}

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }
    val context = LocalContext.current

    NavHost(navController, startDestination = Screen.GetStarted.route) {
        //Get Started
        composable(Screen.GetStarted.route) {
            GetStartedScreen(actions)
        }

        // Home
        composable(Screen.ClothesList.route) {
            val viewModel: MainViewModel = viewModel(
                factory = HiltViewModelFactory(LocalContext.current, it)
            )
            viewModel.getAllClothes(context = context)
            HomeScreen(viewModel, actions)
        }

        // Clothes Details
        composable(
            "${Screen.Details.route}/{name}",
            arguments = listOf(navArgument(EndPoints.NAME) { type = NavType.StringType })
        ) {
            val viewModel = hiltViewModel<MainViewModel>(it)
            val name = it.arguments?.getString(EndPoints.NAME)
                ?: throw IllegalStateException("'Name of Product' shouldn't be null")

            viewModel.getClothesByName(context = context, name = name)
            DetailScreen(viewModel)
        }
    }
}

class MainActions(navController: NavController) {

    val gotoClothesDetails: (String) -> Unit = { name ->
        navController.navigate("${Screen.Details.route}/$name")
    }

    val gotoClothesList: () -> Unit = {
        navController.navigate(Screen.ClothesList.route)
    }
}