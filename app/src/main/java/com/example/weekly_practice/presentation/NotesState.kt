package com.example.weekly_practice.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.weekly_practice.data.local.Note


data class NotesState(
    val taskName : MutableState<String> = mutableStateOf(""),
    val taskDescription : MutableState<String> = mutableStateOf(""),
    val notes : List<Note> = emptyList()
)