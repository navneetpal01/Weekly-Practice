package com.example.weekly_practice.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [Contact::class],
    version = 1
)
abstract class ContactsDatabase : RoomDatabase(){


    abstract val contactsDao : ContactsDao

}