package com.example.weekly_practice.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddNoteScreen(
    state : NoteState,
    onClick : (NotesEvent) -> Unit
){
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onClick(NotesEvent.SaveNote)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Save Note"
                )
            }
        }
    ){paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            TextField(
                value = state.task.value,
                onValueChange = {
                    state.task.value = it
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            TextField(
                value = state.description.value,
                onValueChange = {
                    state.description.value = it
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }
    }
}