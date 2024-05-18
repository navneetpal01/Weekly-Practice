package com.example.weekly_practice.data.remote


sealed class ActivityResult<out T>(
    val data : T? = null,
    val error : String? = null
){
    class Success<T>(data: T?) : ActivityResult<T>(data = data)
    class Failure(message : String) : ActivityResult<Nothing>(error = message)
}