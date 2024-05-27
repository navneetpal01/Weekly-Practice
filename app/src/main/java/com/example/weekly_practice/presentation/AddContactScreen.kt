package com.example.weekly_practice.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.weekly_practice.MainViewModel


@Composable
fun AddContactScreen(
    viewModel: MainViewModel,
    onClick : (ContactsEvent) -> Unit
){

    val state = viewModel.contactsState.collectAsState().value

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onClick(ContactsEvent.AddContact)
                }
            ) {
                Icon(imageVector = Icons.Default.Done, contentDescription = null)
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
                value = state.contactName.value,
                onValueChange = {
                    state.contactName.value = it
                }
            )
            TextField(
                value = state.contactNumber.value,
                onValueChange = {
                    state.contactNumber.value = it
                }
            )
        }


    }
}