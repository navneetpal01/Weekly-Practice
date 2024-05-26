package com.example.weekly_practice.data.repository

import com.example.weekly_practice.data.remote.CurrencyApi
import com.example.weekly_practice.data.remote.CurrencyResult
import com.example.weekly_practice.domain.repository.CurrencyRepository
import com.example.weekly_practice.model.Currency
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class CurrencyRepositoryImpl(
    private val currencyApi: CurrencyApi
) : CurrencyRepository{

    override fun getCurrencyDetails(): Flow<CurrencyResult<Currency>> {
        return flow {
            val result = try {
                currencyApi.getCurrencyData()
            }catch (e : Exception){
                emit(CurrencyResult.Failure(error = e.message ?: "Something went wrong"))
                return@flow
            }
            emit(CurrencyResult.Success(data = result))
        }
    }

}