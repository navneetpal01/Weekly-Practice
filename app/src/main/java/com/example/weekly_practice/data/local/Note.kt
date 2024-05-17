package com.example.weekly_practice.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Note(
    val task : String,
    val description : String,
    val dateAdded : Long,

    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
)