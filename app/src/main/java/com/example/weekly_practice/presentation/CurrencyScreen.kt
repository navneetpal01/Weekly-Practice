package com.example.weekly_practice.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.weekly_practice.model.Bpi


@Composable
fun CurrencyData(
    modifier: Modifier = Modifier,
    bpi: Bpi
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Euro",
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = bpi.EUR.code,
            fontSize = 15.sp,
            color = Color.Green
        )
        Text(
            text = bpi.EUR.rate_float.toString(),
            fontSize = 15.sp,
            color = Color.Green
        )
        Text(
            text = "Dollar",
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = bpi.USD.code,
            fontSize = 15.sp,
            color = Color.Green
        )
        Text(
            text = bpi.USD.rate_float.toString(),
            fontSize = 15.sp,
            color = Color.Green
        )
        Text(
            text = "GBP",
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = bpi.GBP.rate_float.toString(),
            fontSize = 15.sp,
            color = Color.Green
        )
    }
}