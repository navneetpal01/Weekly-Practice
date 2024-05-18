package com.example.weekly_practice.presentation


sealed interface ActivityEvent{
    object ButtonPressed : ActivityEvent
}