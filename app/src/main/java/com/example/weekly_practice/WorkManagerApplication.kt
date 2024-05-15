package com.example.weekly_practice

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.WorkerFactory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


@HiltAndroidApp
class WorkManagerApplication() : Application() , Configuration.Provider{

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override lateinit var workManagerConfiguration: Configuration

    override fun onCreate() {
        super.onCreate()
        workManagerConfiguration = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }

}