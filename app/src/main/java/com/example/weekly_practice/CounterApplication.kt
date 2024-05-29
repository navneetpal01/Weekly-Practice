package com.example.weekly_practice

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.example.weekly_practice.utils.Constants.CHANNEL_ID


class CounterApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Counter Notification",
                NotificationChannel.
            )
            notificationManager.createNotificationChannel(channel)
        }
    }

}