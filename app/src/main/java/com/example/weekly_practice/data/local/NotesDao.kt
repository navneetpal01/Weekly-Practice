package com.example.weekly_practice.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface NotesDao{



    @Upsert
    suspend fun addNote(note : Note)


    @Query("SELECT * FROM NOTE")
    suspend fun getNotes() : Flow<List<Note>>






}

