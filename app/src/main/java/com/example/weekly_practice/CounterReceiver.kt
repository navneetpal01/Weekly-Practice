package com.example.weekly_practice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch


class CounterReceiver : BroadcastReceiver(){

    lateinit var counterNotification : CounterNotification
    var job : Job? = null
    override fun onReceive(context: Context, intent: Intent) {
        counterNotification = CounterNotification(context)
        when(intent.action){
            CounterActions.START.name -> start()
            CounterActions.STOP.name -> stop()
        }
    }

    private fun start(){
        job = CoroutineScope(Dispatchers.IO + SupervisorJob()).launch {
            Counter.startCounter().collect{CounterValue ->
                counterNotification.counterNotification(CounterValue)
            }
        }
    }
    fun stop(){
        job?.cancel()
        Counter.stopCounter()
    }

}