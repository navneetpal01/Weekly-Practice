package com.example.weekly_practice.data.remote

import retrofit2.http.GET


interface CatFactApi {


    @GET("fact")
    suspend fun getCatFact(): CatFact


    companion object {
        const val BASE_URL = "https://catfact.ninja/"
    }


}