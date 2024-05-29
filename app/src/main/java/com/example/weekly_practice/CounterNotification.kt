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


    fun counterNotification() {


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
            .setContentText(Counter.counterValue.toString())
            .setStyle(NotificationCompat.BigPictureStyle())
            .setContentIntent(notificationClickPendingIntent)
            .addAction(

            )
    }

    fun getPendingIntentForAction(
        action : CounterReceiver.CounterAction,
        flag : Int,
        requestCode : Int
    ): PendingIntent {

        val intent = Intent(context,CounterReceiver::class.java)
        when(action){
            CounterReceiver.CounterAction.START ->
            CounterReceiver.CounterAction.STOP ->
        }
        return PendingIntent.getBroadcast(
            context,

        )

    }

}