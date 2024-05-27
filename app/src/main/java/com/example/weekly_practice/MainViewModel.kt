package com.example.weekly_practice

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weekly_practice.data.local.Contact
import com.example.weekly_practice.data.local.ContactsDatabase
import com.example.weekly_practice.presentation.ContactsEvent
import com.example.weekly_practice.presentation.ContactsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val contactsDatabase: ContactsDatabase
) : ViewModel() {

    val contactsList = contactsDatabase.contactsDao.allContacts().stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(), emptyList()
    )

    private val _contactsState = MutableStateFlow(ContactsState())

    val contactsState = combine(contactsList, _contactsState) { contactsList, contactsState ->

        contactsState.copy(
            listContacts = contactsList
        )

    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ContactsState())


    fun onEvent(event : ContactsEvent){

        when(event){
            ContactsEvent.AddContact -> {
                val contact = Contact(
                    name = contactsState.value.contactName.value,
                    phoneNumber = contactsState.value.contactNumber.value.toLong()
                )
                viewModelScope.launch {
                    contactsDatabase.contactsDao.addContact(contact)
                }
                _contactsState.update {
                    it.copy(
                        contactName = mutableStateOf(""),
                        contactNumber = mutableStateOf("")
                    )
                }
            }
            ContactsEvent.DeleteContact -> {

            }
        }

    }


}