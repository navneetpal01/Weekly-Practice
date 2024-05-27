package com.example.weekly_practice.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface ContactsDao{

    @Upsert
    suspend fun addContact(contact : Contact)

    @Query("SELECT * FROM CONTACT")
    fun allContacts() : Flow<List<Contact>>

    @Delete
    suspend fun deleteContact(contact: Contact)


}