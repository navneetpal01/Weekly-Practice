package com.example.weekly_practice.data.repository

import com.example.weekly_practice.data.remote.ActivityApi
import com.example.weekly_practice.data.remote.ActivityResult
import com.example.weekly_practice.domain.repository.ActivityRepository
import com.example.weekly_practice.model.Activity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class ActivityRepositoryImpl(
    private val activityApi: ActivityApi
) : ActivityRepository{

    override fun getActivityDetails(): Flow<ActivityResult<Activity>> {
        return flow {
            val result = try {
                activityApi.getActivity()
            }catch (e : Exception){
                emit(ActivityResult.Failure(message = e.toString()))
                return@flow
            }
            emit(ActivityResult.Success(data = result))
        }
    }
}