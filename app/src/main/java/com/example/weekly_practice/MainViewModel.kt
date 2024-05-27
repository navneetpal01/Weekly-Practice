package com.example.weekly_practice

import androidx.lifecycle.ViewModel
import com.example.weekly_practice.data.local.ContactsDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val contactsDatabase: ContactsDatabase
): ViewModel(){



}