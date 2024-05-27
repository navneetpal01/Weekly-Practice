package com.example.weekly_practice.di

import android.app.Application
import androidx.compose.foundation.rememberBasicTooltipState
import androidx.room.Room
import com.example.weekly_practice.data.local.ContactsDao
import com.example.weekly_practice.data.local.ContactsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule{


    @Provides
    @Singleton
    fun providesContactsDatabase(application: Application) : ContactsDatabase{
        return Room.databaseBuilder(
            application,
            ContactsDatabase::class.java,
            "contacts.db"
        ).build()

    }


}