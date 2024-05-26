package com.example.weekly_practice.di

import com.example.weekly_practice.data.remote.CurrencyApi
import com.example.weekly_practice.data.repository.CurrencyRepositoryImpl
import com.example.weekly_practice.domain.repository.CurrencyRepository
import com.example.weekly_practice.model.Currency
import com.example.weekly_practice.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{


    @Provides
    @Singleton
    fun providesCurrencyApi() : CurrencyApi{

        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client : OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
            .create(CurrencyApi::class.java)
    }


    @Provides
    @Singleton
    fun providesCurrencyRepository(currencyApi: CurrencyApi) : CurrencyRepository{
        return CurrencyRepositoryImpl(currencyApi)
    }


}