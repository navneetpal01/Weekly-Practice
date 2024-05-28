package com.example.weekly_practice.di

import android.content.Context
import com.example.weekly_practice.DataSyncRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Provides
    @Singleton
    fun providesDataSyncRepository(@ApplicationContext context : Context) : DataSyncRepository{
        return DataSyncRepository(context)
    }


}