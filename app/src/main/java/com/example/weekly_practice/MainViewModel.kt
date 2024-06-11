package com.example.weekly_practice

import androidx.lifecycle.ViewModel
import com.example.weekly_practice.data.local.NotesDatabase
import com.example.weekly_practice.presentation.NotesEvent
import com.example.weekly_practice.presentation.NotesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow


@HiltViewModel
class MainViewModel (
   private val notesDatabase: NotesDatabase
): ViewModel(){



   val state = MutableStateFlow<NotesState>(NotesState())



   fun onEvent(event : NotesEvent){
      when(event){
         NotesEvent.AddNote -> {

         }
      }

   }

}