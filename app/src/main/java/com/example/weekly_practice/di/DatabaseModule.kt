package com.example.weekly_practice.di

import android.content.Context
import androidx.room.Room
import com.example.weekly_practice.data.local.NotesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule{



    @Provides
    @Singleton
    fun providesRoomDatabase(@ApplicationContext context : Context) : NotesDatabase{
        return Room.databaseBuilder(
            context,
            NotesDatabase::class.java,
            "notes.dp"
        ).build()
    }

}