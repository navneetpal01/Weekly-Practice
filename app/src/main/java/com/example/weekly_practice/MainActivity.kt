package com.example.weekly_practice

import android.Manifest
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.weekly_practice.ui.theme.WeeklyPracticeTheme


class MainActivity : ComponentActivity() {

    val viewModel by viewModels<MainViewModel>()
    val permissions = arrayOf(
        Manifest.permission.CAMERA,
        Manifest.permission.RECORD_AUDIO
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            WeeklyPracticeTheme {
                val showDialog = viewModel.showDialog.collectAsState().value
                val launchToSettings = viewModel.launchToSettings.collectAsState().value

                val activityResultLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.RequestMultiplePermissions()
                ) {result ->
                    permissions.forEach {permission ->
                        if (result[permission] == false){
                            if (!shouldShowRequestPermissionRationale(permission)){
                                viewModel.updateLaunchToSettings(true)
                            }else{
                                viewModel.updateShowDialog(true)
                            }
                        }
                    }

                }

                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){

                    if (showDialog) {
                        ShowPermissionDialog(
                            onButtonClick = {

                            },
                            onDismiss = {

                            }
                        )
                    }
                }

            }
        }
    }


    @Composable
    fun ShowPermissionDialog(
        onButtonClick: () -> Unit,
        onDismiss: () -> Unit
    ) {
        AlertDialog(
            modifier = Modifier
                .fillMaxWidth(),
            onDismissRequest = onDismiss,
            confirmButton = {
                Button(
                    onClick = onButtonClick
                ) {
                    Text(text = "Ok")
                }
            },
            title = {
                Text(text = "Camera and Microphone Permissions are needed")
            },
            text = {
                Text(text = "This app needs access to your camera and microphone")
            }
        )

    }

}