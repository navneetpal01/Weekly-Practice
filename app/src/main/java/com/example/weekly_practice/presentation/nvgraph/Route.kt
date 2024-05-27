package com.example.weekly_practice.presentation.nvgraph

import kotlinx.serialization.Serializable


@Serializable
sealed class Route{

    @Serializable
    object ContactsScreen : Route()

    @Serializable
    object AddContactScreen : Route()

}