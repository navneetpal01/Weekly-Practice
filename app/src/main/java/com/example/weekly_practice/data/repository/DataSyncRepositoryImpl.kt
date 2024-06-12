package com.example.weekly_practice.data.repository

import android.content.Context
import android.util.Log
import com.example.weekly_practice.domain.repository.DataSyncRepository
import kotlinx.coroutines.delay


class DataSyncRepositoryImpl(
    context : Context
): DataSyncRepository{
    override suspend fun syncData() {
        delay(1500)
        Log.d("pokemon", "Data Synced Failed")
        throw Exception("Failed")
        Log.d("pokemon", "Data Synced Successful")
    }

}