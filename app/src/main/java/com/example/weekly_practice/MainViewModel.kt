package com.example.weekly_practice

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MainViewModel : ViewModel(){

    private val _showDialog = MutableStateFlow(false)
    private val _launchToSettings = MutableStateFlow(false)


    val showDialog = _showDialog.asStateFlow()
    val launchToSettings = _launchToSettings.asStateFlow()




    fun updateShowDialog(value : Boolean){
        _showDialog.update { value }
    }

    fun updateLaunchToSettings(value : Boolean){
        _launchToSettings.update { value }
    }








}