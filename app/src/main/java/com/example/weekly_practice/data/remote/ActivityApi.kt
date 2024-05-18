package com.example.weekly_practice.data.remote

import com.example.weekly_practice.model.Activity
import retrofit2.http.GET


interface ActivityApi{

    @GET("activity")
    suspend fun getActivity() : Activity
}