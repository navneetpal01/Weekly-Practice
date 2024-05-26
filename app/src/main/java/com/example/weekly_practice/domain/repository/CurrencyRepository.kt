package com.example.weekly_practice.domain.repository

import com.example.weekly_practice.data.remote.CurrencyResult
import com.example.weekly_practice.model.Currency
import kotlinx.coroutines.flow.Flow


interface CurrencyRepository{

    fun getCurrencyDetails() : Flow<CurrencyResult<Currency>>

}