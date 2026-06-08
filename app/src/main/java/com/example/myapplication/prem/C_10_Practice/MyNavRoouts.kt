package com.example.myapplication.prem.C_10_Practice

import kotlinx.serialization.Serializable

@Serializable
sealed class MyNavRoouts {

    @Serializable
    object LoginScrUI : MyNavRoouts()

    @Serializable
    object HomeScrUI : MyNavRoouts()
}