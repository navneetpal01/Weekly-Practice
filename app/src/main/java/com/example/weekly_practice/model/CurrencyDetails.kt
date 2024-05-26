package com.example.weekly_practice.model



data class CurrencyDetails(
    val code : String,
    val symbol : String,
    val rate : String,
    val description : String,
    val rate_float : Float
)