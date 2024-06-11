package com.example.weekly_practice.presentation.nvgarph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weekly_practice.presentation.AddNotesScreen
import com.example.weekly_practice.presentation.NotesScreen


@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Route.NotesScreen.screenName
) {


    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(route = Route.NotesScreen.screenName){
            NotesScreen()
        }

        composable(route = Route.AddNotesScreen.screenName){
            AddNotesScreen()
        }


    }


}