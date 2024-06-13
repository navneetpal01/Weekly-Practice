package com.example.weekly_practice

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.weekly_practice.utils.Constants.CHANNEL_ID


class CounterNotification(val context: Context) {

    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


    fun counterNotification(counterValue: Int) {
        val intent = Intent(context, MainActivity::class.java)
        val flag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) PendingIntent.FLAG_IMMUTABLE else 0

        val pendingIntent = PendingIntent.getActivity(
            context,
            99,
            intent,
            flag
        )

        val notification = NotificationCompat.Builder(
            context,
            CHANNEL_ID
        )
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Counter")
            .setContentText(counterValue.toString())
            .setContentIntent(pendingIntent)
            .setStyle(NotificationCompat.BigPictureStyle())

    }



}

enum class CounterActions{
    START,
    STOP
}