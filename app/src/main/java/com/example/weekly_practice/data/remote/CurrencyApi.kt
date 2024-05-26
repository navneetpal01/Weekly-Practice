package com.example.weekly_practice.data.remote

import com.example.weekly_practice.model.Currency
import retrofit2.http.GET


interface CurrencyApi{

    @GET("currentprice.json")
    suspend fun getCurrencyData() : Currency

}