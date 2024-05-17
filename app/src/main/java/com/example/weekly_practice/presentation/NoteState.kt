package com.example.weekly_practice.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.weekly_practice.data.local.Note


data class NoteState(
    val task : MutableState<String> = mutableStateOf(""),
    val description : MutableState<String> = mutableStateOf(""),
    val notes : List<Note> = emptyList()
)