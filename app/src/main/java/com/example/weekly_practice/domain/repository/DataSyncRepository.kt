package com.example.weekly_practice.domain.repository

import android.content.Context


interface DataSyncRepository {



    suspend fun syncData()

}