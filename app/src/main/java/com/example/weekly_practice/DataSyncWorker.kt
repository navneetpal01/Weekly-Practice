package com.example.weekly_practice

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.weekly_practice.domain.repository.DataSyncRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject


@HiltWorker
class DataSyncWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val dataSyncRepository: DataSyncRepository
) : CoroutineWorker(
    context,
    params
) {
    override suspend fun doWork(): Result {
        return try {
            dataSyncRepository.syncData()
            Result.success()
        } catch (e: Exception) {
            e.printStackTrace()
            Result.retry()
        }
    }

}