package com.example.weekly_practice.model



data class Activity(
    val activity : String,
    val type : String,
    val participants : Int,
    val price : Float,
    val link : String,
    val key : Long,
    val accessibility : Float
)