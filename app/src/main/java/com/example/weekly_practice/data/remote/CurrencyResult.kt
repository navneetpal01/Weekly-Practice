package com.example.weekly_practice.data.remote



sealed class CurrencyResult<out T>(
    val data : T? = null,
    val error : String? = null
){
    class Success<T>(data: T?) : CurrencyResult<T>(data = data)
    class Failure(error: String) : CurrencyResult<Nothing>(error = error)
}

