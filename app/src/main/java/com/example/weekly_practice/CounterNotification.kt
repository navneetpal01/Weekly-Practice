package com.example.weekly_practice

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.weekly_practice.utils.Constants.CHANNEL_ID


class CounterNotification(
    val context: Context
) {

    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


    fun notification(counterValue: Int) {
        val flag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) PendingIntent.FLAG_IMMUTABLE else 0
        val intent = Intent(context, MainActivity::class.java)
        val notificationPendingIntent = PendingIntent.getActivity(
            context,
            1,
            intent,
            flag
        )
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Counter")
            .setContentText("Counter value")
            .setOngoing(true)
            .setStyle(NotificationCompat.BigTextStyle())
            .setContentIntent(notificationPendingIntent)
            .addAction(
                R.drawable.ic_launcher_foreground,
                "Start",
                getPendingIntent(
                    CounterActions.START,
                    flag,
                    2
                )
            )
            .addAction(
                R.drawable.ic_launcher_foreground,
                "Stop",
                getPendingIntent(
                    CounterActions.START,
                    flag,
                    3
                )
            )
            .build()
        notificationManager.notify(1, notification)

    }

    private fun getPendingIntent(
        action : CounterActions,
        flag : Int,
        requestCode : Int
    ) : PendingIntent{
        val intent = Intent(context,CounterReceiver::class.java)
        when(action){
            CounterActions.START -> intent.action = CounterActions.START.name
            CounterActions.STOP ->  intent.action = CounterActions.STOP.name
        }
        return PendingIntent.getBroadcast(
            context,
            requestCode,
            intent,
            flag
        )

    }

    enum class CounterActions{
        START,
        STOP
    }

}