package com.example.weekly_practice.presentation

import com.example.weekly_practice.data.local.Note


sealed interface NotesEvent {
    object ShortNotes : NotesEvent
    data class SaveNote(
        val taskName: String,
        val taskDescription: String
    ) : NotesEvent

    data class DeleteNote(val note: Note) : NotesEvent
}