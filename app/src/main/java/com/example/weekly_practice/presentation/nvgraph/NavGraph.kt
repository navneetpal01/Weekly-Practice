package com.example.weekly_practice.presentation.nvgraph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weekly_practice.presentation.AddNoteScreen
import com.example.weekly_practice.presentation.NotesScreen
import com.example.weekly_practice.presentation.NotesViewModel


@Composable
fun NavGraph(
    navController : NavHostController = rememberNavController(),
    startDestination: Route.NotesScreen
){


    val viewModel = viewModel<NotesViewModel>()
    val state = viewModel.state.collectAsState().value

   NavHost(
       navController = navController,
       startDestination = startDestination
   ){

       composable<Route.NotesScreen> {
           NotesScreen(
               state = state,
               onClick = {
                   navController.navigate(Route.AddNotesScreen)
               }
           )
       }

       composable<Route.AddNotesScreen> {
           AddNoteScreen(
               state = state,
               onClick = {
                   viewModel.onEvent(it)
                   navController.popBackStack()
               }
           )
       }

   }






}