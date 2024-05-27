package com.example.weekly_practice.presentation.nvgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weekly_practice.presentation.AddContactScreen
import com.example.weekly_practice.presentation.ContactsScreen


@Composable
fun NavGraph(
    navController : NavHostController = rememberNavController(),
    startDestination : Route = Route.ContactsScreen
){


    NavHost(
        navController = navController,
        startDestination = startDestination
    ){

        composable<Route.ContactsScreen> {
            ContactsScreen()
        }


        composable<Route.AddContactScreen> {
            AddContactScreen()
        }
    }


}