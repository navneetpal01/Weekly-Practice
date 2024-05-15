package com.example.weekly_practice

import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkerFactory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


@HiltAndroidApp
class WorkManagerApplication() : Application(), Configuration.Provider {


    override lateinit var workManagerConfiguration: Configuration

    @Inject
    private lateinit var workerFactory : WorkerFactory

    override fun onCreate() {
        super.onCreate()

        workManagerConfiguration = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()

    }
}