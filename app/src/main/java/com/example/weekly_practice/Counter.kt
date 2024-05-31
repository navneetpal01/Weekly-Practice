package com.example.weekly_practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


object Counter{

    var counterValue : Int = 0
    var isRunning : Boolean = true


   suspend fun start() : Flow<Int>{
        return flow {
            isRunning = true
            while (isRunning){
                counterValue++
                emit(counterValue)
                delay(1000)
            }
        }

    }


    fun stop(){
        isRunning = false
        counterValue = 0
    }





}