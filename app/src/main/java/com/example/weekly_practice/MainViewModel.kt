package com.example.weekly_practice

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weekly_practice.data.local.Note
import com.example.weekly_practice.data.local.NotesDatabase
import com.example.weekly_practice.presentation.NoteState
import com.example.weekly_practice.presentation.NotesEvent
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
    private val isOrderByDateAdded = MutableStateFlow(true)

    private val notes = isOrderByDateAdded.flatMapLatest { isOrderByDateAdded ->
        if (isOrderByDateAdded) {
            notesDatabase.notesDao.getNotes()
        } else {
            notesDatabase.notesDao.getNotesOrderByTittle()
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())


    val _state = MutableStateFlow<NoteState>(NoteState())

    val state = combine(isOrderByDateAdded, notes, _state) { isOrderByDateAdded, notes, state ->
        state.copy(
            notes = notes
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NoteState())

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    notesDatabase.notesDao.deleteNote(event.note)
                }
            }

            is NotesEvent.SaveNote -> {
                val note = Note(
                    task = state.value.task.value,
                    description = state.value.description.value,
                    dateAdded = System.currentTimeMillis(),
                )
                viewModelScope.launch {
                    notesDatabase.notesDao.upsertNote(note)
                }

                _state.update {
                    it.copy(
                        task = mutableStateOf(""),
                        description = mutableStateOf(""),
                    )
                }
            }

            NotesEvent.ShortNotes -> {
                isOrderByDateAdded.value = !isOrderByDateAdded.value
            }
        }
    }
}