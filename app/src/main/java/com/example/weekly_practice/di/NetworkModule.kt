package com.example.weekly_practice.di

import com.example.weekly_practice.data.remote.ActivityApi
import com.example.weekly_practice.data.repository.ActivityRepositoryImpl
import com.example.weekly_practice.domain.repository.ActivityRepository
import com.example.weekly_practice.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{


    @Provides
    @Singleton
    fun providesActivityApi() : ActivityApi{

        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(BASE_URL)
            .build()
            .create(ActivityApi::class.java)
    }


    @Provides
    @Singleton
    fun providesActivityRepository(activityApi: ActivityApi) : ActivityRepository{
        return ActivityRepositoryImpl(activityApi)
    }

}