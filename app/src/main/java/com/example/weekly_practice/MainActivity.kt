package com.example.weekly_practice

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontVariation
import com.example.weekly_practice.ui.WeeklyPracticeTheme


class MainActivity : ComponentActivity() {


    private val viewModel by viewModels<MainViewModel>()
    private val permissions = arrayOf(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO)
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
                val showDialog by viewModel.showDialog.collectAsState()
                val launchToSettings by viewModel.launchToSettings.collectAsState()

                val launcher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.RequestMultiplePermissions()
                ) { permission ->
                    permissions.forEach {
                        if (permission[it] == false) {
                            if (!shouldShowRequestPermissionRationale(it)) {
                                viewModel.updateLaunchToSettings(true)
                            }
                            viewModel.updateShowDialog(true)
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            permissions.forEach { permission ->
                                val granted =
                                    checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
                                if (!granted) {
                                    if (shouldShowRequestPermissionRationale(permission)) {
                                        viewModel.updateShowDialog(true)
                                    } else {
                                        launcher.launch(permissions)
                                    }
                                }

                            }
                        }
                    ) {
                        Text(text = "Start Call")
                    }
                }
                if (showDialog) {
                    PermissionDialog(
                        onClick = {
                            viewModel.updateShowDialog(false)
                            if (launchToSettings) {
                                Intent(
                                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                    Uri.fromParts("package", packageName, null)
                                ).also {
                                    startActivity(it)
                                }
                                viewModel.updateLaunchToSettings(false)
                            } else {
                                launcher.launch(permissions)
                            }
                        },
                        onDismiss = {
                            viewModel.updateShowDialog(false)
                        }
                    )
                }
            }
        }
    }

}

@Composable
private fun PermissionDialog(
    onClick: () -> Unit,
    onDismiss: () -> Unit
) {

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(
                onClick = onClick
            ) {
                Text(text = "Ok")
            }
        },
        modifier = Modifier
            .fillMaxWidth(),
        title = {
            Text(text = "Required Permissions")
        },
        text = {
            Text(text = "Camera and Microphone permissions are required to start the call")
        }
    )

}