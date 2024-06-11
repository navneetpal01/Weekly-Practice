package com.example.weekly_practice.presentation.nvgarph






sealed class Route(
    val screenName : String
){

    object NotesScreen : Route(screenName = "NotesScreen")
    object AddNotesScreen : Route(screenName = "AddNotesScreen")


}