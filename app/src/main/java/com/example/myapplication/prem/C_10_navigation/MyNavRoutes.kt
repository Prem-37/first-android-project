package com.example.myapplication.prem.C_10_navigation

import kotlinx.serialization.Serializable

// Sealed class creates a restricted hierarchy of classes.
// so it subclasses can only be defined in the same file
// Each subclass of sealed class can have its own data and behavivor

@Serializable
sealed class MyNavRoutes {

    @Serializable
    object LoginScreen : MyNavRoutes()

    @Serializable
    object HomeScreen : MyNavRoutes()
    @Serializable
    data class WelcomeScreen(val userName : String) : MyNavRoutes()
}