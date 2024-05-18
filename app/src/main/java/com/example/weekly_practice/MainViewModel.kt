package com.example.weekly_practice

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weekly_practice.data.remote.ActivityResult
import com.example.weekly_practice.domain.repository.ActivityRepository
import com.example.weekly_practice.model.Activity
import com.example.weekly_practice.presentation.ActivityEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val activityRepository: ActivityRepository
) : ViewModel() {

    private val _activity = MutableStateFlow<Activity?>(null)
    val activity = _activity.asStateFlow()


    fun getActivity(event : ActivityEvent) {
        when(event) {
            ActivityEvent.ButtonPressed -> {
                viewModelScope.launch {
                    activityRepository.getActivityDetails().collectLatest { activityResult ->
                        when (activityResult) {
                            is ActivityResult.Failure -> {
                                Log.d("Failed to Fetch the Activity", "${activityResult.error}")
                            }

                            is ActivityResult.Success -> {
                                activityResult.data?.let { activity ->
                                    _activity.update { activity }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}