package com.example.weekly_practice.di

import com.example.weekly_practice.data.remote.CatFactApi
import com.example.weekly_practice.data.repository.CatFactRepositoryImpl
import com.example.weekly_practice.domain.repository.CatFactRepository
import com.example.weekly_practice.uitls.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
    fun providesCatFactApi() : CatFactApi{

        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client : OkHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(httpLoggingInterceptor)
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(BASE_URL)
            .build()
            .create(CatFactApi::class.java)


    }


    @Provides
    @Singleton
    fun providesCatFactRepository(catFactApi: CatFactApi) : CatFactRepository{
        return CatFactRepositoryImpl(catFactApi)
    }






}
