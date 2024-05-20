package com.example.weekly_practice

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MainViewModel : ViewModel() {

    private val _showDialog = MutableStateFlow(false)
    val showDialog = _showDialog.asStateFlow()

    private val _launchToSettings = MutableStateFlow(false)
    val launchToSettings = _launchToSettings.asStateFlow()

    fun updateShowDialog(showDialog: Boolean) {
        _showDialog.update {
            showDialog
        }
    }

    fun updateLaunchToSettings(launchToSettings: Boolean) {
        _launchToSettings.update {
            launchToSettings
        }
    }

}