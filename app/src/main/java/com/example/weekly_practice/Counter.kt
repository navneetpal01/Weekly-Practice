package com.example.weekly_practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class Counter {

    var counterValue: Int = 0
    var isActive: Boolean = true


    suspend fun startCounter(): Flow<Int> {
        return flow {
            isActive = true
            while (isActive) {
                emit(counterValue)
                delay(1200)
                counterValue++
            }
        }

    }

    fun stop(){
        isActive = false
        counterValue = 0
    }


}