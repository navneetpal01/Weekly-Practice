package com.example.weekly_practice

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.weekly_practice.utils.Constants.CHANNEL_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CounterService(
    private val context : Context
): Service(){
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            CounterValues.START.name -> {}
            CounterValues.STOP.name -> {}
        }
        return super.onStartCommand(intent, flags, startId)
    }



    private fun start(){
        CoroutineScope(Dispatchers.IO).launch {
            Counter.start().collect{counterValue ->


            }
        }

    }


    private fun notification(){

        val notification = NotificationCompat.Builder(context,CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .
            .build()




    }





    enum class CounterValues{
        START,
        STOP
    }



}