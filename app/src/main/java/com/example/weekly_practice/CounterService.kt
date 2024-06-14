package com.example.weekly_practice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.weekly_practice.utils.Constants.CHANNEL_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CounterService : Service() {

    private val counter = Counter()

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            CounterActions.START.name -> start()
            CounterActions.STOP.name -> stop()
        }
        return super.onStartCommand(intent, flags, startId)
    }


    private fun start() {
        CoroutineScope(Dispatchers.IO).launch {
            counter.startCounter().collect { counterValues ->
                notification(counterValues)
            }
        }
    }

    private fun stop() {
        counter.stop()
        stopSelf()

    }




    private fun notification(counterValue: Int) {
        val notification = NotificationCompat.Builder(
            this,
            CHANNEL_ID
        )
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Counter")
            .setContentText(counterValue.toString())
            .build()

        startForeground(1, notification)

    }


}


enum class CounterActions {
    START,
    STOP
}