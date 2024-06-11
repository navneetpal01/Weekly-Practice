package com.example.weekly_practice.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun AddNotesScreen(
    noteState : NotesState,
    onAddClick : (NotesEvent) -> Unit
){

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onAddClick.invoke(NotesEvent.AddNote)
                }
            ) {
                Icon(imageVector = Icons.Default.Check, contentDescription = null)
            }
        }
    ){paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ){
            TextField(
                value = noteState.taskName.value,
                onValueChange = {
                    noteState.taskName.value = it
                }
            )
            TextField(
                value = noteState.taskDescription.value,
                onValueChange = {
                    noteState.taskDescription.value = it
                }
            )
        }

    }





}