package com.example.weekly_practice.presentation.nvgarph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weekly_practice.MainViewModel
import com.example.weekly_practice.presentation.AddNotesScreen
import com.example.weekly_practice.presentation.NotesScreen


@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Route.NotesScreen.screenName
) {
    val viewModel = viewModel<MainViewModel>()
    val state by viewModel.state.collectAsState()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(route = Route.NotesScreen.screenName) {
            NotesScreen(
                onAddClick = {
                    if (navController.canGoBack){
                        navController.navigate(Route.AddNotesScreen.screenName)
                    }
                },
                noteState = state
            )
        }

        composable(route = Route.AddNotesScreen.screenName) {
            AddNotesScreen(
                noteState = state,
                onAddClick = {
                    viewModel.onEvent(it)
                    if (navController.canGoBack){
                        navController.popBackStack()
                    }
                }
            )
        }
    }
}

val NavHostController.canGoBack : Boolean
    get() =  this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED