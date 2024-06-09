package com.example.weekly_practice.data.remote




sealed class CatFactResult<out T>(
    val data : T? = null,
    val error : String? = null
){

    class Success<T>(data: T?) : CatFactResult<T>(data = data)
    class Failure(error: String) : CatFactResult<Nothing>(error = error)



}