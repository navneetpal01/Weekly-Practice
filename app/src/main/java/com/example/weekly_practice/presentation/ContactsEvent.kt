package com.example.weekly_practice.presentation

import com.example.weekly_practice.data.local.Contact


sealed interface ContactsEvent{
    object AddContact : ContactsEvent
    object DeleteContact : ContactsEvent
}