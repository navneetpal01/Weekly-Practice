package com.example.weekly_practice.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.weekly_practice.data.local.Contact


data class ContactsState(
    val contactName : MutableState<String> = mutableStateOf(""),
    val contactNumber : MutableState<String> = mutableStateOf(""),
    val listContacts : List<Contact> = emptyList()
)