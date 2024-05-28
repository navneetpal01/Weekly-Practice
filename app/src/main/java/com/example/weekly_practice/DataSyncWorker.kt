package com.example.weekly_practice

import android.content.Context
import android.content.ContextParams
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject


@HiltWorker
class DataSyncWorker @AssistedInject constructor(
    @Assisted context : Context,
    @Assisted params: WorkerParameters,
    private val dataSyncRepository: DataSyncRepository
): CoroutineWorker(
    context,
    params,
){
    override suspend fun doWork(): Result {
        return try {
            dataSyncRepository.syncData()
            Result.success()
        }catch (e : Exception){
            Result.retry()
        }
    }

}