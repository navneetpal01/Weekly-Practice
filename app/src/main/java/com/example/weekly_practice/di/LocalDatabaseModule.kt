package com.example.weekly_practice.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weekly_practice.data.local.NotesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalDatabaseModule{


    @Provides
    @Singleton
    fun providesNotesDatabase(application: Application) : NotesDatabase{
        return Room.databaseBuilder(
            application,
            NotesDatabase::class.java,
            "notes.db"
        ).build()
    }

}