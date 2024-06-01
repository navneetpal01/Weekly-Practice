package com.example.weekly_practice

import android.Manifest
import android.graphics.Color
import android.os.Bundle
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.weekly_practice.ui.WeeklyPracticeTheme


class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private val permissions = arrayOf(Manifest.permission.CAMERA,Manifest.permission.RECORD_AUDIO)
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

                val permissionLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.RequestMultiplePermissions()
                ) {

                }
                
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Button(
                        onClick = { 
                            permissionLauncher.launch(permissions)
                        }
                    ) {
                        Text(text = "Start")
                    }
                }

            }
        }
    }

}


@Composable
fun ShowPermissionDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(
                onClick = onConfirm
            ) {
                Text(text = "Ok")
            }
        },
        title = {
            Text(text = "Allow the permissions to Continue")
        },
        text = {
            Text(text = "Need microphone and camera permission to continue")
        },
        modifier = Modifier
            .fillMaxWidth()
    )

}