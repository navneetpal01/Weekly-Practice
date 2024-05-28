package com.example.weekly_practice

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.work.BackoffPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.weekly_practice.ui.WeeklyPracticeTheme
import dagger.hilt.android.AndroidEntryPoint
import java.time.Duration


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        initOneTimeWorkRequest(this)
        setContent {
            WeeklyPracticeTheme {
            }
        }
    }

}

private fun initOneTimeWorkRequest(context : Context) {
    val workRequest = OneTimeWorkRequestBuilder<DataSyncWorker>()
        .setInitialDelay(Duration.ofSeconds(10))
        .setBackoffCriteria(
            backoffPolicy = BackoffPolicy.EXPONENTIAL,
            duration = Duration.ofSeconds(10)
        )
        .build()

    WorkManager.getInstance(context).enqueue(workRequest)
}