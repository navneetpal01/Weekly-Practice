package com.example.weekly_practice.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface NotesDao {


    @Upsert
    suspend fun upsertNote(note: Note)


    @Delete
    suspend fun deleteNote(note: Note)


    @Query("SELECT * FROM NOTE ORDER BY dateAdded")
    fun getNotes(): Flow<List<Note>>


    @Query("SELECT * FROM NOTE ORDER BY description ASC")
    fun getNotesOrderByTittle(): Flow<List<Note>>


}