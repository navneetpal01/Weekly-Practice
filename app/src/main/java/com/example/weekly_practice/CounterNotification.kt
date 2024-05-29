package com.example.weekly_practice

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.weekly_practice.utils.Constants.CHANNEL_ID


class CounterNotification(
    private val context: Context
) {

    private val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


    fun counterNotification(counterValue : Int) {

        val flag =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) PendingIntent.FLAG_IMMUTABLE else 0
        val intent = Intent(context, MainActivity::class.java)
        val notificationClickPendingIntent = PendingIntent.getActivity(
            context,
            1,
            intent,
            flag
        )


        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Counter")
            .setContentText(counterValue.toString())
            .setStyle(NotificationCompat.BigPictureStyle())
            .setContentIntent(notificationClickPendingIntent)
            .addAction(
                R.drawable.ic_launcher_foreground,
                "Start",
                getPendingIntentForAction(
                    CounterReceiver.CounterAction.START,
                    flag,
                    2
                )
            )
            .addAction(
                R.drawable.ic_launcher_foreground,
                "Stop",
                getPendingIntentForAction(
                    CounterReceiver.CounterAction.STOP,
                    flag,
                    3
                )
            )
            .build()
        notificationManager.notify(7,notification)
    }

    fun getPendingIntentForAction(
        action : CounterReceiver.CounterAction,
        flag : Int,
        requestCode : Int
    ): PendingIntent {

        val intent = Intent(context,CounterReceiver::class.java)
        when(action){
            CounterReceiver.CounterAction.START -> intent.action = CounterReceiver.CounterAction.START.name
            CounterReceiver.CounterAction.STOP -> intent.action = CounterReceiver.CounterAction.STOP.name
        }
        return PendingIntent.getBroadcast(
            context,
            requestCode,
            intent,
            flag
        )

    }

}