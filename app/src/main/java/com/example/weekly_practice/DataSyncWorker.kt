package com.example.weekly_practice

import androidx.work.CoroutineWorker
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject


class DataSyncWorker @AssistedInject constructor(

): CoroutineWorker(

){
    override suspend fun doWork(): Result {
        TODO("Not yet implemented")
    }

}