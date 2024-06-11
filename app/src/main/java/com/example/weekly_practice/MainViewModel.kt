package com.example.weekly_practice

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weekly_practice.data.local.Note
import com.example.weekly_practice.data.local.NotesDatabase
import com.example.weekly_practice.presentation.Note
import com.example.weekly_practice.presentation.NotesEvent
import com.example.weekly_practice.presentation.NotesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
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
                val note = Note(
                    task = state.value.taskName.value,
                    description = state.value.taskDescription.value
                )
                viewModelScope.launch {
                    notesDatabase.notesDao.addNote(note)
                }
                _state.update {
                    it.copy(
                        taskName = mutableStateOf(""),
                        taskDescription = mutableStateOf("")
                    )
                }
            }
        }

    }

}