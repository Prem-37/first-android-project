package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.myapplication.prem.C13_Navigation_Bar.NavBarHomeScreen
import com.example.myapplication.prem.C13_Navigation_Bar.NavBarNavigation
import com.example.myapplication.prem.SnackBarExample
import com.example.myapplication.prem.ToastExample
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                SnackBarExample()
            }
        }
    }
}
