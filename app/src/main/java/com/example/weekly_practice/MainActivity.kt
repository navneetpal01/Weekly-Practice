package com.example.weekly_practice

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.weekly_practice.ui.theme.WeeklyPracticeTheme


class MainActivity : ComponentActivity(){

    val viewModel by viewModels<MainViewModel>()
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



            }
        }
    }


    @Composable
    fun ShowPermissionDialog(
        onClick : () -> Unit,
        onDismiss : () -> Unit
    ){
        AlertDialog(
            modifier = Modifier
                .fillMaxWidth(),
            onDismissRequest = onDismiss,
            confirmButton = {
                Button(
                    onClick = onClick
                ) {
                    Text(text = "Ok")
                }
            },
            title = {
                Text(text = "Camera and Microphone Permissions are needed")
            }
        )

    }

}