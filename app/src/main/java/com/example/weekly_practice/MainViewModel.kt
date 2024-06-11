package com.example.weekly_practice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weekly_practice.data.local.NotesDatabase
import com.example.weekly_practice.presentation.NotesEvent
import com.example.weekly_practice.presentation.NotesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn


@HiltViewModel
class MainViewModel(
    private val notesDatabase: NotesDatabase
) : ViewModel() {


    val notes = notesDatabase.notesDao.getNotes().stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            emptyList()
        )


    val _state = MutableStateFlow<NotesState>(NotesState())
    val state = combine(notes, _state) { notes, _state ->
        _state.copy(
            notes = notes
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),NotesState())


    fun onEvent(event: NotesEvent) {
        when (event) {
            NotesEvent.AddNote -> {

            }
        }

    }

}