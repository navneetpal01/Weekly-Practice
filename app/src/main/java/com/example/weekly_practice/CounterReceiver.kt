package com.example.weekly_practice

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch


class CounterReceiver : BroadcastReceiver(){


    private lateinit var counterNotification: CounterNotification
    private var counterJob : Job? = null

    override fun onReceive(context: Context, intent: Intent) {
        counterNotification = CounterNotification(context)
        when(intent.action){
            CounterNotification.CounterActions.START.name -> start()
            CounterNotification.CounterActions.STOP.name -> stop()
        }
    }


    private fun start(){
       counterJob =  CoroutineScope(SupervisorJob() +  Dispatchers.IO).launch {
           Counter.startCounter().collect{counterValues ->
               counterNotification.notification(counterValues)
           }
        }
    }

    private fun stop(){
        counterJob?.cancel()
        Counter.stop()
        counterNotification.notification(0)
    }


}
