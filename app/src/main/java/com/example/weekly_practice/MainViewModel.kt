package com.example.weekly_practice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weekly_practice.data.local.NotesDatabase
import com.example.weekly_practice.presentation.NoteState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val notesDatabase: NotesDatabase
): ViewModel(){
    private val isOrderByDateAdded = MutableStateFlow(true)

    private val notes = isOrderByDateAdded.flatMapLatest { isOrderByDateAdded ->
        if (isOrderByDateAdded){
            notesDatabase.notesDao.getNotes()
        }else{
            notesDatabase.notesDao.getNotesOrderByTittle()
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())


    private val _state = MutableStateFlow<NoteState>(NoteState())

    val state = combine(isOrderByDateAdded,notes,_state){isOrderByDateAdded , notes , state ->
        state.copy(
            notes = notes
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),NoteState())



}