package com.example.weekly_practice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


class CounterReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action){
            CounterAction.START.name ->{}
            CounterAction.STOP.name -> {}
        }
    }


    fun start(){

    }
    fun stop(){

    }






    enum class CounterAction{
        START,
        STOP
    }

}

