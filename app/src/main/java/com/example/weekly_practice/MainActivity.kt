package com.example.weekly_practice

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.example.weekly_practice.model.Bpi
import com.example.weekly_practice.model.Currency
import com.example.weekly_practice.model.CurrencyDetails
import com.example.weekly_practice.presentation.CurrencyScreen
import com.example.weekly_practice.ui.theme.WeeklyPracticeTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            val currency = viewModel.currencyData.collectAsState().value
            WeeklyPracticeTheme {
                currency?.let {
                    CurrencyScreen(bpi = it.bpi)
                }
            }
        }
    }

}