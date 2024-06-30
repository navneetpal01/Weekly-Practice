package com.example.weekly_practice.data.repository

import com.example.weekly_practice.data.remote.CatFact
import com.example.weekly_practice.data.remote.CatFactApi
import com.example.weekly_practice.data.remote.CatFactResult
import com.example.weekly_practice.domain.repository.CatFactRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class CatFactRepositoryImpl(
    private val catFactApi: CatFactApi
): CatFactRepository{


    override fun getCatFact(): Flow<CatFactResult<CatFact>> {
        return flow {
            val result = try {
                catFactApi.getCatFact()
            }catch (e : Exception){
                emit(CatFactResult.Failure(error = e.message ?: "Network Error"))
                return@flow
            }
            emit(CatFactResult.Success(data = result))
        }
    }


}