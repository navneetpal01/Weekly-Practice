package com.example.weekly_practice.data.local

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper


@Database(
    entities = [Note::class],
    version = 1
)


abstract class NotesDatabase : RoomDatabase() {


    abstract val notesDao : NotesDao





}


