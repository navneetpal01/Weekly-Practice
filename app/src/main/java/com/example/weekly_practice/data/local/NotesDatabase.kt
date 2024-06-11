package com.example.weekly_practice.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [Note::class],
    version = 1
)
abstract class NotesDatabase : RoomDatabase(){

    abstract val notesDao : NotesDao


}