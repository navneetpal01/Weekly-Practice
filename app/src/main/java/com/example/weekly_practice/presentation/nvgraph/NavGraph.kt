package com.example.weekly_practice.presentation.nvgraph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weekly_practice.MainViewModel
import com.example.weekly_practice.presentation.AddContactScreen
import com.example.weekly_practice.presentation.ContactsScreen


@Composable
fun NavGraph(
    navController : NavHostController = rememberNavController(),
    startDestination : Route = Route.ContactsScreen
){

    val viewModel = viewModel<MainViewModel>()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){

        composable<Route.ContactsScreen> {
            ContactsScreen(
                viewModel = viewModel,
                onClick = {
                    navController.navigate(Route.AddContactScreen)
                }
            )
        }


        composable<Route.AddContactScreen> {
            AddContactScreen(
                viewModel = viewModel,
                onClick = {
                    viewModel.onEvent(it)
                    navController.navigate(Route.ContactsScreen)
                }
            )
        }
    }


}