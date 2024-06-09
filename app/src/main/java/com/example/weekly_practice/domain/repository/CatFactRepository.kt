package com.example.weekly_practice.domain.repository

import com.example.weekly_practice.data.remote.CatFact
import com.example.weekly_practice.data.remote.CatFactResult
import kotlinx.coroutines.flow.Flow


interface CatFactRepository{

    fun getCatFact() : Flow<CatFactResult<CatFact>>

}