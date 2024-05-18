package com.example.weekly_practice.domain.repository

import com.example.weekly_practice.data.remote.ActivityResult
import com.example.weekly_practice.model.Activity
import kotlinx.coroutines.flow.Flow


interface ActivityRepository{

    fun getActivityDetails() : Flow<ActivityResult<Activity>>
}