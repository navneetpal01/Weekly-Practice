package com.example.weekly_practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


object Counter{

    var counterValue : Int = 0
    var isActive : Boolean = true




    fun startCounter() : Flow<Int>{
        return flow {
            while (isActive){
                emit(counterValue)
                counterValue++
                delay(1500)
            }
        }
    }

    fun stop(){
        isActive = false
        counterValue = 0
    }







}