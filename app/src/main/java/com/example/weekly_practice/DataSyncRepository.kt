package com.example.weekly_practice

import android.content.Context
import android.util.Log
import kotlinx.coroutines.delay


class DataSyncRepository(context : Context){


    suspend fun syncData(){
        delay(2000)
        Log.d("retrofit", "Data sync successfully values got updated :-")
        Exception()
    }


}