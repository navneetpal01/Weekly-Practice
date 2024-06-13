package com.example.weekly_practice

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


object Counter {

    var counterValue: Int = 0
    var isRunning: Boolean = true


    fun startCounter() : Flow<Int>{
        return flow {
            isRunning = true
            while (isRunning){
                emit(counterValue)
                counterValue ++
            }
        }
    }

    fun stopCounter(){
        isRunning = false
        counterValue = 0
    }


}