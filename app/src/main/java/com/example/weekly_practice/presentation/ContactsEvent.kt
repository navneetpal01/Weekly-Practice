package com.example.weekly_practice.presentation

import com.example.weekly_practice.data.local.Contact


sealed interface ContactsEvent{
    data class AddContact(val contact : Contact) : ContactsEvent
    data class DeleteContact(val contact: Contact) : ContactsEvent
}