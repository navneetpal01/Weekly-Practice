package com.example.weekly_practice.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Contact(
    val name : String,
    val phoneNumber : Long,


    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
)