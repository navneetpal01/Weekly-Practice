package com.example.weekly_practice.di

import android.content.Context
import com.example.weekly_practice.data.repository.DataSyncRepositoryImpl
import com.example.weekly_practice.domain.repository.DataSyncRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule{


    @Provides
    @Singleton
    fun providesDataSyncRepository(@ApplicationContext context : Context) : DataSyncRepository{
        return DataSyncRepositoryImpl(context)
    }



}